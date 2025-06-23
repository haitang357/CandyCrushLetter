package com.codetest.candycrushletter.util;

import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RepeatCharHandler {

    private static void replaceRepeatChar(String input, BiFunction<String, String, String> function) {
        System.out.println("Input: " + input);

        String regex = "([a-zA-Z])\\1{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("Output:");
        while (matcher.find()) {
            String repeatString = matcher.group();

            input = function.apply(input, repeatString);

            matcher = pattern.matcher(input);
        }
    }

    public static void removeRepeatChar(String input) {
        BiFunction<String, String, String> function = (inputString, repeatString) -> {
            inputString = inputString.replace(repeatString, "");
            System.out.println("-> " + inputString);
            return inputString;
        };

        replaceRepeatChar(input, function);
    }

    public static void replaceRepeatCharWithPreviousChar(String input) {
        BiFunction<String, String, String> function = (inputString, repeatString) -> {
            char repeatChar = repeatString.charAt(0);

            if (repeatChar != 'a' && repeatChar != 'A') {
                int repeatAscii = (int) repeatChar;
                char previousChar = (char) (repeatAscii - 1);
                inputString = inputString.replace(repeatString, Character.toString(previousChar));
                System.out.println("-> " + inputString + ", " + repeatString + " is replaced by " + previousChar);
            } else {
                inputString = inputString.replace(repeatString, "");
                System.out.println("-> " + inputString);
            }

            return inputString;
        };

        replaceRepeatChar(input, function);
    }

}
