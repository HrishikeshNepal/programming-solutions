import java.util.*;
import java.util.stream.Collectors;

class Anagram {
    /*
    1) two strings having different length
    2) empty strings
    3) one fully upper case and one lower case
    4) strings with repetitive characters
     */
    public static void main(String[] args) {
        String str1 = "mother in laww   ww";
        String str2 = "Hitler wwww   oman";
        System.out.println(checkAnagrams(str1, str2));
        System.out.println(checkAnagrams_solution2(str1, str2));

    }

    // Solution 1
    public static boolean checkAnagrams(String str1, String str2) {
        /*
        time complexity: best case O(n), worst case O(n*n)
        space complexity: ignoring constants defined, it is using an array of length n to store values during computation.
                          strings, values of i and visited are constants with each O(1) space
                          total space required = O(c + n) = O(n)
         */
        str1 = str1.strip().replace(" ", "").toLowerCase();
        str2 = str2.strip().replace(" ", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        int i = 0;
        int visited = -1;
        int n = str1.length();
        int[] array = new int[n];

        while (i != n) {
            for (int j = 0; j < n; j++) {
                if ((str1.charAt(i) == str2.charAt(j) && array[j] != visited)) {
                    array[j] = visited;
                    i++;
                    break;
                } else if ((str1.charAt(i) != str2.charAt(j)) && j+1 == n) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solution 2:
    public static boolean checkAnagrams_solution2(String str1, String str2){
        str1 = str1.strip().replace(" ", "").toLowerCase();
        str2 = str2.strip().replace(" ", "").toLowerCase();
        Map<Character, Integer> map1 = getMapForCharacters(str1.toCharArray());
        Map<Character, Integer> map2 = getMapForCharacters(str2.toCharArray());
        return map1.equals(map2);
    }

    public static Map<Character, Integer> getMapForCharacters(char[] array){
        List<Character> list = new ArrayList<>();
        for(char ch: array){
            list.add(ch);
        }
        Set<Character> set = list.stream().collect(Collectors.toSet());
        Map<Character, Integer> map = set.stream().collect(Collectors
            .toMap(key -> key, value -> Collections.frequency(list, value)));
        return map;
    }
}
