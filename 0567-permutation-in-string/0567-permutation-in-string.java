class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] target = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(target, window))
            return true;

        for (int i = n; i < m; i++) {
            window[s2.charAt(i - n) - 'a']--;
            window[s2.charAt(i) - 'a']++;

            if (matches(target, window)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}