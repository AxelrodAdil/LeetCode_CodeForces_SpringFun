package leetcode.y2023m02.yandex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class BarChart {

    // 13.02.2023 - A
    
    private static String getFileData(File file) {
        var input = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEachOrdered(line -> input.append(line).append(" "));
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
        return input.toString();
    }

    public static void getBarChart(String input){
        var frequency = new TreeMap<Character, Integer>();
        IntStream.range(0, input.length()).forEachOrdered(i -> {
            var c = input.charAt(i);
            if (Character.isWhitespace(c) || c == '\n') return;
            frequency.put(c, frequency.containsKey(c) ? frequency.get(c) + 1 : 1);
        });
        var maxFrequency = 0;
        for (var value : frequency.values()) {
            maxFrequency = Math.max(maxFrequency, value);
        }
        IntStream.iterate(maxFrequency, i -> i > 0, i -> i - 1).forEachOrdered(i -> {
            for (var c : frequency.keySet()) {
                System.out.print(frequency.get(c) >= i ? "#" : " ");
                System.out.print("");
            }
            System.out.println();
        });
        frequency.keySet().stream().map(c -> c + "").forEach(System.out::print);
    }

    public static void main(String[] args) {
        var file = new File("input.txt");
        var input = getFileData(file);
        getBarChart(input);
    }

    /*
      Hello, world!
           #
           ##
      #########
      !,Hdelorw

      =====================

      Twas brillig, and the slithy toves
      Did gyre and gimble in the wabe;
      All mimsy were the borogoves,
      And the mome raths outgrabe.

               #
               #
               #
               #
               #
               #         #
               #  #      #
            #  # ###  ####
            ## ###### ####
            ##############
            ##############  ##
      #  #  ############## ###
      ########################
      ,.;ADTabdeghilmnorstuvwy
     */
}
