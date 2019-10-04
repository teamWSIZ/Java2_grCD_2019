package com.generics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pattern pattern = Pattern.compile("(\\d{4})-(\\d{4})");
        Matcher matcher = pattern.matcher("1010-2345");

        System.out.println(matcher.find());
        System.out.println(matcher.matches());

        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }
}
