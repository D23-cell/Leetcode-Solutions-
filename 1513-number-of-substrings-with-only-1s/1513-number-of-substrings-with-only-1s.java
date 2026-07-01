class Solution {
    static int MOD = 1000000007;
    public int numSub(String s) {
        int n = s.length();
        int count = 0;
        int ans = 0;
    for (int i = 0; i < n; i =i+1) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count = 0;
            }
            ans = (ans + count) % MOD;
        }
        return ans;
    }
}