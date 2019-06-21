/*
 * DESCRIPTION:
 *
 * 1. For the string str = "abcd.135\tuvqz.7\ttzik.999\n"
 *      - print the count of sub-sequence that match letters.numberWhitespace pattern
 *      - print the numbers from the sub-sequence and their start and end index
 *
 * 2. For the string str2 = "{0,2}, {0,5}, {1,3}, {2,4}";
 *      - extract the numbers within the curly braces
 *
 * 3. Write a regex to match US phone number (123) 456-7890
 *
 * 4.Given the following string of html code,
 *      - check if the html code is within valid body tags
 *      - print all h2 tags with its count
 *      - print out the contents in each paragraph tag
 *
 * HTML CODE:
 * <body>
 *     <h1> my house </h1>
 *     <div>
 *      `   <h2> nice house </h2>
 *         <div>
 *             <p> paragraph 1 </p>
 *             <p> paragraph 2 </p>
 *         </div>
 *         <span> span tag </span>
 *         <h2> ending... </h2>
 *         <p> last paragraph </p>
 *     </div>
 * </body>
 */

package com.ablaze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        StringBuilder  html = new StringBuilder();

        html.append("<body><h1> my house </h1>");
        html.append("<div><h2> nice house </h2>");
        html.append("<div>");
        html.append("<p> paragraph 1 </p>");
        html.append("<p> paragraph 2 </p>");
        html.append("</div>");
        html.append("<span> span tag </span><h2> ending... </h2><p> last paragraph </p>");
        html.append("</div></body>");
    }
}


//Regex for US phone number [(][0-9]{3}[)][ ][0-9]{3}[-][0-9]{4}