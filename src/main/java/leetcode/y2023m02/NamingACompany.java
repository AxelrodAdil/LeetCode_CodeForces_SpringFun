package leetcode.y2023m02;

import java.util.*;

public class NamingACompany {

    // https://leetcode.com/problems/naming-a-company/

    public long distinctNames(String[] ideas) {
        /*
        Runtime 452 ms
        Beats 58.73%
        Memory 58 MB
        Beats 39.68%
        */
        var map = new HashMap<Character, Set<String>>();
        Arrays.stream(ideas).forEachOrdered(s -> {
            if (map.containsKey(s.charAt(0))) {
                map.get(s.charAt(0)).add(s.substring(1));
            } else {
                Set<String> set = new HashSet<>();
                set.add(s.substring(1));
                map.put(s.charAt(0), set);
            }
        });
        long ans = 0;
        for (char c1 : map.keySet()) {
            for (char c2 : map.keySet()) {
                if (c1 == c2) continue;
                var mutual = (int) map.get(c1).stream().filter(s -> map.get(c2).contains(s)).count();
                long d1 = map.get(c1).size() - mutual;
                long d2 = map.get(c2).size() - mutual;
                ans += d1 * d2;
            }
        }
        return ans;
    }

    public long distinctNamesButTimeLimitExceeded(String[] ideas) {
        // Time Limit Exceeded: 74 / 89 testcases passed
        var countHashSet = new HashSet<String>();
        var ans = new HashSet<String>();
        Collections.addAll(countHashSet, ideas);
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                if (ideas[i].charAt(0) == ideas[j].charAt(0)) continue;
                var a = ideas[i].charAt(0) + ideas[j].substring(1);
                var b = ideas[j].charAt(0) + ideas[i].substring(1);
                if (countHashSet.contains(a) || countHashSet.contains(b)) continue;
                ans.add(a.concat(" ").concat(b));
            }
        }
        return ans.size() * 2L;
    }
}
