package core;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapClass {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<String, String>();
        contacts.put("Антон", "+7(727)293-70-58");
        contacts.put("Одногруппник Магжан", "+7(727)355-41-26");
        contacts.put("Апашка", "+7(727)224-21-11");
        contacts.put("Сантехник Антон", "+7(727)292-90-94");
//        System.out.println(searchPhonebook(contacts, "Антон"));
        contacts.hashCode();

        System.out.println("------------------------------");
//        print();
        String example = "Astana";
        System.out.println(countLetters(example));
    }

    public static HashMap<Character, Integer> countLetters(String text) {
        String textMain = text.toLowerCase();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < textMain.length(); i++) {
            if(hashMap.get(textMain.charAt(i)) == null){
                hashMap.put(textMain.charAt(i), 1);
            } else {
                hashMap.put(textMain.charAt(i), hashMap.get(textMain.charAt(i))+1);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            System.out.print(hashMap.get(textMain.charAt(i)) + " ");
        }

        return hashMap;
    }


    public static HashMap<String, String> searchPhonebook(HashMap<String, String> phonebook, String value) {
        HashMap<String, String> ans = new HashMap<>();
        for(String i:phonebook.keySet()){
            if(i.contains(value)){
                ans.put(i, phonebook.get(i));
            }
        }
        return ans;
    }

    public static HashMap<String, Integer> familyMembersCount(String[] people) {
        String[] arr = new String[people.length];
        for (int i = 0; i < people.length; i++) {
            int start = people[i].indexOf(" ") + 1;
            int end = people[i].length();
            String temp = people[i].substring(start, end);
            arr[i] = temp;
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String i:arr){
            String temp = i.substring(0, i.length()-1);
            char at = i.charAt(i.length()-1);
            System.out.println("HERE: " + i +" - "+temp +" - "+at);
            if(at == 'а'){
                hashMap.put(temp,hashMap.get(temp) == null ? 1 : hashMap.get(temp) + 1);
            } else {
                hashMap.put(i,hashMap.get(i) == null ? 1 : hashMap.get(i) + 1);
            }
        }
        return hashMap;
    }

    public static int[] findUniques(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Integer i:array){
            hashMap.put(i,hashMap.get(i) == null ? 1 : hashMap.get(i) + 1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer i:hashMap.keySet()){
            if(hashMap.get(i) == 1){
                arrayList.add(i);
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static int[] findDuplicates(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Integer i:array){
            hashMap.put(i,hashMap.get(i) == null ? 1 : hashMap.get(i) + 1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer i:hashMap.keySet()){
            if(hashMap.get(i) > 1){
                arrayList.add(i);
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static HashMap<String, Integer> wordFreq(String text) {
        String textMain = text.toLowerCase();
        String temp = textMain.replaceAll(",", "").replaceAll("\\s{2,}", " ").replaceAll("\\t", " ").trim();
        System.out.println("\n" + temp);
        String[] arr = temp.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String i : arr) hashMap.put(i, hashMap.get(i) == null ? 1 : hashMap.get(i) + 1);
        return hashMap;
    }

    public static void print(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "key1");
        hashMap.put("4", "key2");
        hashMap.put("3", "key3");
        hashMap.put("2", "key4");
        System.out.println(hashMap.containsKey("Hello"));
        System.out.println("------------------------------");
//        System.out.println(countLetters("Guyana"));
//        System.out.println(wordFreq("Chisinau, Lisboa Plymouth, Baku\t \tBaku    Baku\tBaku\t "));
//        System.out.println(Arrays.toString(findDuplicates(new int[]{56, 77, 25, 16, 58, 25, 16, 58})));
//        System.out.println(Arrays.toString(findDuplicates(new int[]{31, 31, 31, 31, 31})));
//        System.out.println(Arrays.toString(findUniques(new int[]{1, 2})));
//        String[] people = {
//                "Серик Ахметов",
//                "Айнур Абаева",
//                "Ерсултан Кенес",
//                "Жанар Ахметова",
//                "Рашид Абаев",
//                "Раушан Кенес"
//        };
//        System.out.println(familyMembersCount(people));
    }
}