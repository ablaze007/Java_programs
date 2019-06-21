//DESCRIPTION: 

package com.ablaze;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesParameterized {
    private String input;
    private String output;
    private Utilities u;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"112233445566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }

    public UtilitiesParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Before
    public void setup() {
        u = new Utilities();
    }

    @Test
    public void test() {
        assertEquals(output, u.removePairs(input));
    }

}
