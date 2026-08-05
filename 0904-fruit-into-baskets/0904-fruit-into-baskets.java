class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> fruit = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {

            fruit.put(fruits[right], fruit.getOrDefault(fruits[right], 0) + 1);

            while (fruit.size() > 2) {

                fruit.put(fruits[left], fruit.get(fruits[left]) - 1);

                if (fruit.get(fruits[left]) == 0) {
                    fruit.remove(fruits[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}