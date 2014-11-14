package com.jerome.challenges.selfdesc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
            int n = Integer.valueOf(line);
            System.out.println(isSelfDescNum(n));
        }
        reader.close();
    }

    private static int isSelfDescNum(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            if (((int)cs[i]-48)!=getCount(i,cs)){
                return 0;
            }
        }
        return 1;
    }

    private static int getCount(int i, char[] cs) {
        int s = 0;
        for (char c:cs){
            if (((int)c-48)==i){s++;}
        }
        return s;
    }
}