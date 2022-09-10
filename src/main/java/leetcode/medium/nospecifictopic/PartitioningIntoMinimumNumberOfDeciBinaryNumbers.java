package leetcode.medium.nospecifictopic;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    // https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

    public int minPartitions(String n) {
        /*
        Runtime: 25 ms, faster than 17.10% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
        Memory Usage: 54.8 MB, less than 18.02% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
        */
        int ans = 1;
        for (int i = 0; i < n.length(); i++) {
//            System.out.println("character: " + Character.getNumericValue(n.charAt(i)));
            if (ans < Character.getNumericValue(n.charAt(i))) {
                ans = Character.getNumericValue(n.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbers partitioningIntoMinimumNumberOfDeciBinaryNumbers = new PartitioningIntoMinimumNumberOfDeciBinaryNumbers();
        System.out.println(partitioningIntoMinimumNumberOfDeciBinaryNumbers.minPartitions("32"));
        System.out.println(partitioningIntoMinimumNumberOfDeciBinaryNumbers.minPartitions("82734"));
    }
}
