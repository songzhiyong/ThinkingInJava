package com.jerome.challenges.armstrong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new RuntimeException("Must specify input file path.");
        } else if (args.length > 1) {
            throw new RuntimeException("Illegal input arguments specified.");
        }
        final BufferedReader reader = new BufferedReader(new FileReader(
                new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(isArmstrongNum(Integer.valueOf(line))?"True":"False");
        }
        reader.close();
    }
    public static boolean isArmstrongNum(int n){
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            int digit = (int)cs[i]-48;
            sum+=Math.pow(digit,len);
        }
        return sum==n;
    }
}