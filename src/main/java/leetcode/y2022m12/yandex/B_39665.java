package leetcode.y2022m12.yandex;

import java.util.*;
import java.util.stream.Collectors;

public class B_39665 {

    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = Integer.parseInt(sc.nextLine());
        String[] arrNames = new String[n];
        for (int i = 0; i < n; i++) {
            arrNames[i] = sc.nextLine();
        }
        int m = Integer.parseInt(sc.nextLine());
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] tempArr = sc.nextLine().split(",");
            participants.add(new Participant(tempArr[0], tempArr[1], Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3])));
        }
        List<String> arrListNames = new ArrayList<>();
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < participants.size(); i++) {
            String strEquality = participants.get(i).getDiscipline();
            if (arrListNames.contains(strEquality)) {
                continue;
            } else {
                arrListNames.add(strEquality);
            }
            int finalJ = 0;
            for (String arrName : arrNames) {
                if (arrName.substring(0, arrName.lastIndexOf(",")).equals(strEquality)) {
                    finalJ = Integer.parseInt(arrName.substring(arrName.lastIndexOf(",") + 1));
                    break;
                }
            }
            List<Participant> participantList = Objects.requireNonNull(participants.stream().
                    filter(e -> e.getDiscipline().equals(strEquality)).sorted(Comparator.comparing(Participant::getValue)
                            .thenComparing(Participant::getFine, Comparator.reverseOrder())).collect(Collectors.toList()));
            if (participantList.size() != 1) {
                int finalListSize = participantList.size();
                int tempCount = 0;
                Collections.reverse(participantList);
                for (int j = 0; j < finalJ; j++) {
                    if (tempCount < finalListSize) {
                        ansList.add(participantList.get(j).getName());
                    } else {
                        break;
                    }
                }
            } else {
                ansList.add(participantList.get(0).getName());
            }
        }

        Collections.sort(ansList);
        for (String s : ansList) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int t = 1;
//        int t = Integer.parseInt(sc.next());
        for (int s = 0; s < t; s++) {
            solve();
        }
    }
}

class Participant {

    private String name;
    private String discipline;
    private Integer value;
    private Integer fine;

    public Participant() {

    }

    public Participant(String name, String discipline, Integer value, Integer fine) {
        this.name = name;
        this.discipline = discipline;
        this.value = value;
        this.fine = fine;
    }

    public Integer getFine() {
        return fine;
    }

    public Integer getValue() {
        return value;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", discipline='" + discipline + '\'' +
                ", value=" + value +
                ", fine=" + fine +
                '}';
    }
}
