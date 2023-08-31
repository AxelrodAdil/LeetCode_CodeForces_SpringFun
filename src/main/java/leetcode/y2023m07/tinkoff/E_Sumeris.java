package leetcode.y2023m07.tinkoff;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E_Sumeris {

    static Scanner scanner = new Scanner(System.in);

    public static int chooseHerd(List<String> herd) {
        Map<Integer, Integer> answer = new HashMap<>();
        Map<Character, Integer> horseCounts = new HashMap<>();
        herd.forEach(horses -> {
            for (char horse : horses.toCharArray()) horseCounts.put(horse, horseCounts.getOrDefault(horse, 0) + 1);
        });
        int maxStrength = horseCounts.values().stream().mapToInt(i -> i).sum();
        int minDeformity = Collections.max(horseCounts.values()) - Collections.min(horseCounts.values());
        answer.put(minDeformity, maxStrength);
        IntStream.iterate(herd.size() - 1, k -> k >= 0, k -> k - 1)
                .forEachOrdered(k -> IntStream.iterate(k, i -> i >= 0, i -> i - 1).forEachOrdered(i -> {
                    Map<Character, Integer> currCounts = new HashMap<>(horseCounts);
                    for (char horse : herd.get(i).toCharArray()) {
                        currCounts.put(horse, currCounts.get(horse) - 1);
                    }
                    int currDeformity = Collections.max(currCounts.values()) - Collections.min(currCounts.values());
                    int currStrength = currCounts.values().stream().mapToInt(integer -> integer).sum();
                    if (answer.containsKey(currDeformity)) {
                        if (answer.get(currDeformity) < currStrength) answer.replace(currDeformity, currStrength);
                    } else {
                        answer.put(currDeformity, currStrength);
                    }
                }));
        int minKey = answer.keySet().stream().mapToInt(key -> key).min().orElse(Integer.MAX_VALUE);
        return answer.get(minKey);
    }

    // abcccca    babb
    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<String> herd = IntStream.range(0, n).mapToObj(i -> scanner.next()).collect(Collectors.toList());
        System.out.println(chooseHerd(herd));
    }
}
