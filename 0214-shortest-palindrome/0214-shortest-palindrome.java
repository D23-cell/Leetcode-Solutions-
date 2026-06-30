class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] table = new int[combined.length()];
        
        for (int i = 1; i < combined.length(); i++) {
            int j = table[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = table[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        
        return rev.substring(0, s.length() - table[combined.length() - 1]) + s;
    }
}