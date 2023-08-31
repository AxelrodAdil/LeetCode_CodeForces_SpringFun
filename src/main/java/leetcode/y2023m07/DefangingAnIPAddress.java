package leetcode.y2023m07;

public class DefangingAnIPAddress {

    // https://leetcode.com/problems/defanging-an-ip-address/

    public String defangIPaddr(String address) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.9 MB
        Beats 23.37%
         */
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }

//    public String defangIPaddr(String address) {
//        /*
//        Runtime 2 ms
//        Beats 23.70%
//        Memory 40.7 MB
//        Beats 52.26%
//         */
//        return address.replaceAll("\\.", "[.]");
//    }
}
