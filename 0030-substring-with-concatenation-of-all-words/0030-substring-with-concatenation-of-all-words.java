class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        HashMap<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int right = offset;

            HashMap<String, Integer> current = new HashMap<>();

            int count = 0;

            while (right + wordLength <= s.length()) {

                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (!required.containsKey(word)) {

                    current.clear();
                    count = 0;
                    left = right;

                } else {

                    current.put(
                        word,
                        current.getOrDefault(word, 0) + 1
                    );

                    count++;

                    while (current.get(word) > required.get(word)) {

                        String leftWord =
                            s.substring(left, left + wordLength);

                        current.put(
                            leftWord,
                            current.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);

                        String leftWord =
                            s.substring(left, left + wordLength);

                        current.put(
                            leftWord,
                            current.get(leftWord) - 1
                        );

                        left += wordLength;
                        count--;
                    }
                }
            }
        }

        return result;
    }
}