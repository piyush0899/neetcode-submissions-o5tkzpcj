class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty parts and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                // Normal directory
                stack.push(part);
            }
        }

        // Build the final path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // If stack is empty, we are at root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}