class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (c == '.') {
                // Dot cannot appear after exponent
                // or appear more than once
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } 
            else if (c == 'e' || c == 'E') {
                // Exponent cannot appear twice
                // and must follow a digit
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // Need digits after e/E
            } 
            else {
                return false;
            }
        }

        return seenDigit;
    }
}
