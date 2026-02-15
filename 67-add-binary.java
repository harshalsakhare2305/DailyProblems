//https://leetcode.com/problems/add-binary/?envType=daily-question&envId=2026-02-15

class Solution {
    public String addBinary(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();

        StringBuilder s1 = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(b);

        int diff = Math.abs(lenA - lenB);

        // prepend zeros
        if (lenA < lenB) {
            s1.insert(0, "0".repeat(diff));
        } else {
            s2.insert(0, "0".repeat(diff));
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            int bit1 = s1.charAt(i) - '0';
            int bit2 = s2.charAt(i) - '0';

            int sum = bit1 + bit2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
