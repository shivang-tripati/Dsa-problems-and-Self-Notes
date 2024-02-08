package leetcode;

import java.util.ArrayList;

public class genrateParatheses {
    private static void genrate(String p, int open, int close, ArrayList<String> list) {
        if(open == 0 && close == 0) {
            list.add(p);
            return;
        }
        if(open > 0){
            genrate(p + "(", open-1, close, list);
        }
        if(close > open )
         genrate(p + ")", open, close-1, list);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        genrate("", 5, 5, list );
        System.out.println(list);
    }
}
