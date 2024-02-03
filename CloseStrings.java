/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

 */

import java.util.*;
import java.util.stream.Collectors;

class CloseStrings{

    public static void main(String args[]) {
        String word1 = "aaabbbbccddeeeeefffff";
        String word2 = "aaaaabbcccdddeeeeffff";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m!=n)
            return false;
        Map<Character, Integer> map1 = getMapsForGivenStringCharacters(word1);
        Map<Character, Integer> map2 = getMapsForGivenStringCharacters(word2);
        Map<Character, Integer> map = new HashMap<>();
        //check if key set is same and check frequencies of values
        if(map1.keySet().equals(map2.keySet()) && getFrequenciesOfValues(map1.values()).equals(getFrequenciesOfValues(map2.values()))) {
            map1.entrySet().stream().forEach(
                entry1 -> {
                    map2.entrySet().stream().filter(entry2 -> entry1.getKey() == entry2.getKey()).anyMatch(entry -> {
                        map.put(entry1.getKey(), entry.getValue());
                        return false;
                    });
                }
            );
        } else {
            return false;
        }

        return map.equals(map2);
    }

    public static Map<Character, Integer> getMapsForGivenStringCharacters(String str){
        char[] array = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(Character ch : array){
            list.add(ch);
        }
        Set<Character> set = new HashSet<>(list);
        Map<Character, Integer> map = set.stream().collect(Collectors.toMap(
            key -> key,
            value -> Collections.frequency(list, value)
        ));

        return map;
    }

    public static Map<Integer, Integer> getFrequenciesOfValues(Collection collections){
        Set<Integer> set = new HashSet<>(collections);
        Map<Integer, Integer> map = set.stream().collect(Collectors.toMap(
            key -> key,
            value -> Collections.frequency(collections, value)
        ));

        return map;
    }
}
