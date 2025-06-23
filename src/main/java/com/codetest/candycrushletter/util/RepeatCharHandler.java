package com.codetest.candycrushletter.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RepeatCharHandler {

    public static void removeRepeatChar(String input) {
        System.out.println("Input: " + input);

        String regex = "([a-zA-Z])\\1{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Output:");
        while (matcher.find()) {
            input = input.replace(matcher.group(), "");
            System.out.println("-> " + input);
            matcher = pattern.matcher(input);
        }
    }

    public static void replaceRepeatCharWithPreviousChar(String input) {
        System.out.println("Input: " + input);

        String regex = "([a-zA-Z])\\1{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Output:");
        while (matcher.find()) {
            String repeatString= matcher.group();
            char repeatChar = repeatString.charAt(0);

            if(repeatChar!='a' && repeatChar!='A') {
                int repeatAscii = (int) repeatChar;
                char previousChar = (char) (repeatAscii - 1);
                input = input.replace(repeatString, Character.toString(previousChar));
                System.out.println("-> " + input+", " + repeatString + " is replaced by " + previousChar);
            } else {
                input = input.replace(repeatString, "");
                System.out.println("-> " + input);
            }
            matcher = pattern.matcher(input);
        }
    }

}
