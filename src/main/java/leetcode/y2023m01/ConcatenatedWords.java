package leetcode.y2023m01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatenatedWords {

    // https://leetcode.com/problems/concatenated-words/

    private boolean isConcatenated(TrieNode root, String word, int index) {
        var node = root;
        for (int i = index; i < word.length(); i++) {
            var c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
            if (node.isWord && (i == word.length() - 1 || isConcatenated(root, word, i + 1))) return true;
        }
        return false;
    }

    private boolean isConcatenated(TrieNode root, String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
            if (node.isWord && isConcatenated(root, word, i + 1)) return true;
        }
        return false;
    }

    private void insertWord(TrieNode root, String word) {
        var node = root;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        /*
        Runtime 44 ms
        Beats 94.86%
        Memory 50.6 MB
        Beats 54.63%
        */
        var root = new TrieNode();
        Arrays.stream(words).forEachOrdered(word -> insertWord(root, word));
        return Arrays.stream(words)
                .filter(word -> isConcatenated(root, word))
                .collect(Collectors.toList());
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}
