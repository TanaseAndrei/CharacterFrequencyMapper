package org.ucv.utils;

public class StringUtils {

    public static String[] split(String line, String value){
        return line.split(value);
    }

    public static String concatStrings(String[] strings){
        StringBuilder line = new StringBuilder();
        for(String string : strings){
            line.append(string);
        }
        return line.toString();
    }

    public static int getNumberOfCharacters(String string){
        int totalNumber = 0;
        for(int i = 0; i < string.length(); i++){
            totalNumber += 1;
        }
        return totalNumber;
    }
}
