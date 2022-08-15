package leetcode.easy.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberOfStudentsUnableToEatLunch {

    // https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

    private int validate(Queue<Integer> studentsQueue, Queue<Integer> sandwichesQueue) {
        int count = 0;
        Queue<Integer> temp = new LinkedList<>(studentsQueue);
        while (!temp.isEmpty()) {
            if (temp.peek().equals(sandwichesQueue.peek())) {
                count++;
                temp.remove();
            } else {
                temp.remove();
            }
        }
        return count;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        /*
        Runtime: 17 ms, faster than 5.38% of Java online submissions for Number of Students Unable to Eat Lunch.
        Memory Usage: 49.5 MB, less than 5.09% of Java online submissions for Number of Students Unable to Eat Lunch.
        */
        Queue<Integer> studentsQueue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> sandwichesQueue = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));
        while (!studentsQueue.isEmpty() && !sandwichesQueue.isEmpty()) {
            if (validate(studentsQueue, sandwichesQueue) == 0) {
                break;
            }
            if (Objects.requireNonNull(studentsQueue.peek()).equals(sandwichesQueue.peek())) {
                studentsQueue.remove();
                sandwichesQueue.remove();
            } else {
                int temp = studentsQueue.remove();
                studentsQueue.add(temp);
            }
        }
        return studentsQueue.size();
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch numberOfStudentsUnableToEatLunch = new NumberOfStudentsUnableToEatLunch();
        System.out.println(numberOfStudentsUnableToEatLunch.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
        System.out.println(numberOfStudentsUnableToEatLunch.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}
