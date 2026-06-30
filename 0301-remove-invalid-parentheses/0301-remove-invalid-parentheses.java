class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        java.util.Set<String> visited = new java.util.HashSet<>();
        java.util.Queue<String> queue = new java.util.LinkedList<>();

        queue.add(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                res.add(s);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String next = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}