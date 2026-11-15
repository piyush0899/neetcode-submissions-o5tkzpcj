

class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> roman = new HashMap<>();

        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int currentValue = roman.get(s.charAt(i));

            // Check whether the current symbol is smaller than the next one
            if (i + 1 < s.length() &&
                currentValue < roman.get(s.charAt(i + 1))) {

                result -= currentValue;

            } else {

                result += currentValue;
            }
        }

        return result;
    }
}
