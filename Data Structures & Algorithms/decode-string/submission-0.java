
class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the number
            if (Character.isDigit(ch)) {

                currentNumber = currentNumber * 10 + (ch - '0');

            }

            // Start of encoded string
            else if (ch == '[') {

                countStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = "";
            }

            // End of encoded string
            else if (ch == ']') {

                int repeatCount = countStack.pop();
                String previousString = stringStack.pop();

                StringBuilder temp = new StringBuilder(previousString);

                for (int j = 0; j < repeatCount; j++) {
                    temp.append(currentString);
                }

                currentString = temp.toString();
            }

            // Normal character
            else {

                currentString = currentString + ch;
            }
        }

        return currentString;
    }
}