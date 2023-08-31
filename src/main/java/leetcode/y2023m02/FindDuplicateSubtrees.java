package leetcode.y2023m02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {

    // https://leetcode.com/problems/find-duplicate-subtrees/

    private String helper(List<TreeNodeFindDuplicateSubtrees> ans, HashMap<String, Integer> hashMap,
                          TreeNodeFindDuplicateSubtrees root) {
        if (root == null) return "";
        String left = helper(ans, hashMap, root.left);
        String right = helper(ans, hashMap, root.right);
        int current = root.val;
        String tempResult = current + "*" + left + "*" + right;
        if (hashMap.getOrDefault(tempResult, 0) == 1) ans.add(root);
        hashMap.put(tempResult, hashMap.getOrDefault(tempResult, 0) + 1);
        return tempResult;
    }

    public List<TreeNodeFindDuplicateSubtrees> findDuplicateSubtrees(TreeNodeFindDuplicateSubtrees root) {
        /*
        Runtime 17 ms
        Beats 80.25%
        Memory 46 MB
        Beats 79.38%
        */
        List<TreeNodeFindDuplicateSubtrees> ans = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        helper(ans, hashMap, root);
        return ans;
    }
}

class TreeNodeFindDuplicateSubtrees {
    int val;
    TreeNodeFindDuplicateSubtrees left;
    TreeNodeFindDuplicateSubtrees right;

    TreeNodeFindDuplicateSubtrees() {
    }

    TreeNodeFindDuplicateSubtrees(int val) {
        this.val = val;
    }

    TreeNodeFindDuplicateSubtrees(int val, TreeNodeFindDuplicateSubtrees left, TreeNodeFindDuplicateSubtrees right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
