package com.jerome.challenges.beautifulstring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.*;

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
            System.out.println(beautifulString(line));
        }
        reader.close();
    }

    public static int beautifulString(String str){
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.toLowerCase().charAt(i);
            if (Character.isLetter(c)){
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
            }
        }
        ArrayList<Entry<Character,Integer>> l = new ArrayList<Entry<Character,Integer>>(map.entrySet());
        Collections.sort(l, new Comparator<Entry<Character, Integer>>() {
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        int s = 0;
        int weight = 26;
        for (Entry<Character,Integer> entry:l){
            s+=weight*entry.getValue();
            weight--;
        }
        return s;
    }
}