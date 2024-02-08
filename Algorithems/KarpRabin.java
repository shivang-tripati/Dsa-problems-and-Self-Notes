package Algorithems;

public class KarpRabin {
    private final int PRIME = 101;


    public KarpRabin () {

    }
    

    private long calculateHash(String str) {
        long hash = 0;
        for(int i=0; i< str.length(); i++) {
            hash = (long) (hash + str.charAt(i) * Math.pow(PRIME, i));
        }
        return hash;
    }

    private long updateHash(long prevHash, char oldChar, char newChar, int patternLength){
        long newHash = (prevHash - oldChar) / PRIME ; // to reduce the size of hash and remove the hash of left most index in  text
        newHash += newChar * Math.pow(PRIME, patternLength-1);
        return newHash;

    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) {

            if(textHash == patternHash) {
                if(text.substring(i, i + patternLength).equals(pattern)){
                    System.out.println("pattern found at index " + i);
                }
            }
            if (i < text.length() - patternLength) {
               textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }

            
        }
    }
}
