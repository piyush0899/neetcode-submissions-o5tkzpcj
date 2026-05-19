class Solution {
      public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // operator
            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                if (token.equals("+")) {
                    stack.push(a + b);
                }
                else if (token.equals("-")) {
                    stack.push(a - b);
                }
                else if (token.equals("*")) {
                    stack.push(a * b);
                }
                else {
                    stack.push(a / b);
                }
            }
            else {

                // number
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
