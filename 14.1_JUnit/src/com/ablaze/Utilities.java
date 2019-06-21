//DESCRIPTION: 

package com.ablaze;

public class Utilities {

    //************* METHODS *************
    //returns a char array containing every nth char
    //return sourceArray if length < n
    public char[] everyNthChar(char[] sourceArray, int n) {
        if(sourceArray == null || sourceArray.length < n) {
            return  sourceArray;
        }

        int returnedLength = sourceArray.length/n;
        char[] result = new char[returnedLength];
        for(int i=0; i<returnedLength; i++) {
            result[i] = sourceArray[(n-1)*(i+1)];
        }

        return result;
    }

    //removes pairs of the same character that are next
    //to each other
    //"abcdeef" -> "abcdef"
    public String removePairs(String source) {
        if(source == null || source.length() < 2) {
            return source;
        }

        StringBuilder str = new StringBuilder(Character.toString(source.charAt(0)));
        for(int i=1; i<source.length(); i++){
            char c = source.charAt(i);
            if(c != source.charAt(i-1))
                str.append(Character.toString(c));
        }
        return str.toString();
    }

    //perform a conversion based on some internal rule
    public int converter(int a, int b) {
        return (a/b) + (a*30) - 2;
    }

    public String nullIfOddLength(String source) {
        if((source.length() & 1) == 1){
            return null;
        }
        return source;
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~

}
