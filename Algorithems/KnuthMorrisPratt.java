package Algorithems;

public class KnuthMorrisPratt {

    private static void kmpSearch(String text, String pattern) {
        if (pattern.equals("")) {
            return;
        }

        int n = text.length(), m = pattern.length();
        int[] lps = lps(pattern);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j + 1));
                j = 0;
            }
        }
    }

    private static int[] lps(String pattern) {
        int n = pattern.length();
        int[] lpsArray = new int[n];
        int len = 0; // initial length of lpsArray

        for (int i = 0; i < n; i++) {
            while (len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = lpsArray[len - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
            }

            lpsArray[i] = len;
        }
        return lpsArray;
    }

    public static void main(String[] args) {
        String text = "AAXAAAX";
        String pattern = "AAA";
        kmpSearch(text, pattern);
    }
}
