class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> res, StringBuilder path, String num, int target, int pos, long eval, long mult) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long val = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            if (pos == 0) {
                backtrack(res, path.append(val), num, target, i + 1, val, val);
                path.setLength(len);
            } else {
                backtrack(res, path.append("+").append(val), num, target, i + 1, eval + val, val);
                path.setLength(len);
                backtrack(res, path.append("-").append(val), num, target, i + 1, eval - val, -val);
                path.setLength(len);
                backtrack(res, path.append("*").append(val), num, target, i + 1, eval - mult + mult * val, mult * val);
                path.setLength(len);
            }
        }
    }
}