package leetcode;

import java.util.ArrayList;

public class LetterCombination {
    private  static ArrayList<String> pad(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        int digit =   up.charAt(0) - '0' ;
        if(digit <= 6) {
        for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++ ) {
            char ch = (char) ('a' + i);
             result.addAll(pad(p + ch, up.substring(1)));
        }
        
        } 
        if( digit == 7) {
            for(int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++ ) {
            char ch = (char) ('a' + i);
            result.addAll(pad(p + ch, up.substring(1))) ;
            }
            return result;
        }
        if( digit == 8) {
            for(int i = ((digit - 2) * 3) + 1; i <= (digit - 1) * 3; i++ ) {
            char ch = (char) ('a' + i);
            result.addAll(pad(p + ch, up.substring(1)));
            }
            return result;
        }
        if( digit == 9) {
            for(int i = ((digit - 2) * 3) + 1; i <= ((digit - 1) * 3) + 1; i++ ) {
            char ch = (char) ('a' + i);
            result.addAll(pad(p + ch, up.substring(1)));
        }
        return result;
        }
         return result;
    }
    
    public static void main(String[] args) {
        System.out.println(pad("", "23"));
    }
}
