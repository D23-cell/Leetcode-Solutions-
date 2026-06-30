class Solution {
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict));
    }

    private List<String> dfs(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) return memo.get(s);
        
        List<String> results = new ArrayList<>();
        if (s.isEmpty()) {
            results.add("");
            return results;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                List<String> suffixes = dfs(s.substring(i), wordSet);
                for (String suffix : suffixes) {
                    results.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }
        
        memo.put(s, results);
        return results;
    }
}
