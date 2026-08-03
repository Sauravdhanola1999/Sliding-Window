class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) {
            target[ch - 'a']++;
        }

        int k = p.length();

        for (int right = 0; right < s.length(); right++) {


            window[s.charAt(right) - 'a']++;

            if (right >= k) {
                window[s.charAt(right - k) - 'a']--;
            }

            if (Arrays.equals(target, window)) {
                ans.add(right - k + 1);
            }
        }

        return ans;
    }
}