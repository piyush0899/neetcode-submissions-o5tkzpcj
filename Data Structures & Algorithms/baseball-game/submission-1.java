public class Solution {

    public static int calPoints(String[] operations) {

        int[] stack = new int[operations.length];
        int top = -1;

        for (String op : operations) {

            if (op.equals("C")) {
                top--;

            } else if (op.equals("D")) {
                stack[++top] = 2 * stack[top - 1];

            } else if (op.equals("+")) {
                stack[++top] = stack[top - 1] + stack[top - 2];

            } else {
                stack[++top] = Integer.parseInt(op);
            }
        }

        int sum = 0;

        for (int i = 0; i <= top; i++) {
            sum += stack[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        String[] operations = {"5", "2", "C", "D", "+"};

        System.out.println(calPoints(operations));
    }
}