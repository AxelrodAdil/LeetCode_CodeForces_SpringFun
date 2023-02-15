package leetcode.level.easy.nospecifictopic;

public class AddBinary {

    // https://leetcode.com/problems/add-binary/

    public String addBinary(String a, String b) {
        /*
        Runtime: 2 ms, faster than 91.52% of Java online submissions for Add Binary.
        Memory Usage: 42.8 MB, less than 54.22% of Java online submissions for Add Binary.
        */
//        if (a.length() == 1 && b.length() == 1) {
//            if (getBinary(a, 0) == 0 && getBinary(b, 0) == 0) {
//                return "0";
//            }
//        }
        var sb = new StringBuilder();
        int aLength = a.length() - 1, bLength = b.length() - 1, keepInMind = 0;
        while (aLength >= 0 || bLength >= 0) {
            int sum = keepInMind;
            if (aLength >= 0) sum += a.charAt(aLength--) - '0';
            if (bLength >= 0) sum += b.charAt(bLength--) - '0';
            sb.append(sum % 2);
            keepInMind = sum / 2;
        }
        if (keepInMind > 0) sb.append(keepInMind);
        return sb.reverse().toString();
    }

    private int getBinary(String s, int l) {
        /*
        Runtime: 3 ms, faster than 68.65% of Java online submissions for Add Binary.
        Memory Usage: 42.6 MB, less than 67.48% of Java online submissions for Add Binary.
        */
        if (l < 0) return 0;
        if (s.length() <= l) return 0;
        return s.charAt(l) - '0';
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
