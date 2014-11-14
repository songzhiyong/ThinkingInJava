package com.jerome.challenges.happynumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jerome on 9/27/14.
 */
public class Main {

    public static void main(final String[] args) throws IOException {
        // Verify input argument length.
        if (args.length < 1) {
            throw new RuntimeException("Must specify input file path.");
        } else if (args.length > 1) {
            throw new RuntimeException("Illegal input arguments specified.");
        }

        // Read file from specified path.
        final BufferedReader reader = new BufferedReader(new FileReader(
                new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            int n = Integer.valueOf(line);
            ArrayList<Integer> history = new ArrayList<Integer>();
            System.out.println(isHappyNumber(n, history));
        }
        reader.close();
    }

    public static int isHappyNumber(int n, ArrayList<Integer> history) {
        if (n == 1) {
            return 1;
        } else if (history.contains(n)) {
            return 0;
        } else{
            history.add(n);
            return isHappyNumber(sqrtSum(n),history);
        }

    }
    public static int sqrtSum(int n){
        int s = 0;
        while (n/10>0){
            s+=Math.pow(n%10,2);
            n = n/10;
        }
        s+=Math.pow((n%10),2);
        return s;
    }
}

