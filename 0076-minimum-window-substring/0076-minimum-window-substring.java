class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            
            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }
                if (++map[s.charAt(start++)] > 0) count++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}