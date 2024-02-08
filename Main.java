class Main {
    public static void main(String[] args) {
        // System.out.println("hello world");

        int ans = strStr("somuchsad", "sad");
        System.out.println(ans);
    }

    public static int strStr(String haystack, String needle) {
        
        int m = haystack.length();
        int n = needle.length();

        int j = 0;

        for(int i=0; i < m; i++) {
            if(haystack.charAt(i) == needle.charAt(j) ){
                j++; // increment the index of needle 
            }else{
                //i = i-j; // if mismatch found 
                j = 0;
            }

            if(j == n) {
                return i-n+1;
            }
        }
        return -1;
    }
}