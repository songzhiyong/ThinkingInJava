package com.jerome.basic;

import java.text.SimpleDateFormat;
import java.util.*;

public class SplitWords {
    private static final String delimiters = " \t\n\r\f~!@#$%^&*()_+|`-=\\{}[]:\";'<>?,./'";

    public static String[] split(String source) {
        /* 根据分隔符分词 */
        StringTokenizer stringTokenizer = new StringTokenizer(source,
                delimiters);

        Vector vector = new Vector();

        Vector vectorForAllUpperCase = new Vector();
   
        /* 根据大写字母分词 */
        flag0:
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            System.out.println(token);
            boolean allUpperCase = true;
            for (int i = 0; i < token.length(); i++) {
                if (!Character.isUpperCase(token.charAt(i))) {
                    allUpperCase = false;
                }
            }
            if (allUpperCase) {
                vectorForAllUpperCase.addElement(token);
                continue flag0;
            }
            int index = 0;
            flag1:
            while (index < token.length()) {
                flag2:
                while (true) {
                    index++;
                    if ((index == token.length())
                            || (!Character.isLowerCase(token.charAt(index)) &&(index>0&&Character.isLowerCase(token.charAt(index -1))))
                            || (isChinese(token.charAt(index)) &&(index>0&&!isChinese(token.charAt(index -1))))
                            || (!isChinese(token.charAt(index)) &&(index>0&&isChinese(token.charAt(index -1))))
                            ) {
                        break flag2;
                    }
                }
                vector.addElement(token.substring(0, index).toLowerCase());
                token = token.substring(index);
                index = 0;
                continue flag1;
            }
        }

        for (int i = 0; i < vectorForAllUpperCase.size(); i++) {
            vector.addElement(vectorForAllUpperCase.elementAt(i));
        }

        String[] array = new String[vector.size()];
        Enumeration enumeration = vector.elements();
        int index = 0;
        while (enumeration.hasMoreElements()) {
            array[index] = (String) enumeration.nextElement();
            index++;
        }

        return array;
    }

    public static boolean isChinese(char c){
        return Character.toString(c).matches("[\u4E00-\u9FA5]+");
    }
    public static void main(String args[]) {
        SplitWords sw = new SplitWords();
        String[] strings = sw.split("中国字ABC&你好 SpeedVPN WeChat");
        System.out.println(Arrays.toString(strings));
        SimpleDateFormat formatLetterDay = new SimpleDateFormat("EEEEE", Locale.getDefault());
        String letter = formatLetterDay.format(new Date());
        System.out.println(letter);
        Calendar myCal = Calendar.getInstance();
        String dayOfWeek = myCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
        String month = myCal.getDisplayName(Calendar.MONTH, Calendar.LONG,Locale.getDefault());
        int day = myCal.get(Calendar.DAY_OF_MONTH);
        String date = String.format("%s ,%s %d",dayOfWeek,month,day);
        System.out.println(date.toUpperCase());
    }
} 