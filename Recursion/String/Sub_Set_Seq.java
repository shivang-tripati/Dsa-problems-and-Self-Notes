package Recursion.String;

public class Sub_Set_Seq {

    public static void main(String[] args) {

        // String str = new String("");
        String str = "baccappledh";
        skip("", str);
         String str2 = skip(str);
         String str3 = skipApple("baccappledh"); 
         System.out.println("str2 ->"+ str2 + " Str3 -> " + str3);
         System.out.println(skipAppNotApple("baccappdh"));
    }
 
    // paasing answer in argument for future call
    // process and Un-process patter 
   static void skip(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a') {
            skip(p, up.substring(1) );
        }else{
            skip(p + ch , up.substring(1));
        }
    }
    
    static String skip(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            return skip(str.substring(1));
        } else {
            return ch + skip(str.substring(1));
        }
    }
    //  skip a string

    static String skipApple(String str) {
        if(str.isEmpty()) {
            return "";
        }
        
        if(str.startsWith("apple")) {
            return skipApple(str.substring(5));
        } else {
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    static String skipAppNotApple(String str) {
        if(str.isEmpty()) {
            return "";
        }
        
        if(str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(5));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }

}
