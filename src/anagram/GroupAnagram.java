package anagram;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        List<List<String>> lists = groupAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println("args = " + lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
//        List<Anagram> anagramList = new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();
        HashMap<String,List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String value = String.copyValueOf(chars);
            Anagram anagram = new Anagram(strs[i], value,i);
            if (map.containsKey(value)){
                map.get(value).add(anagram.originalText);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(anagram.originalText);
                map.put(value, list);
            }
//            anagramList.add(anagram);
        }
        //anagramList.sort(Comparator.comparing(str -> str.sortedText));
        //System.out.println("strs = " + Arrays.deepToString(strs) +" anamgrarms: = "+anagramList.toString());
        map.forEach((key, value) -> answer.add(value));
        return answer;
    }
}

class Anagram{
    String originalText;
    String sortedText;
    int order;

    public Anagram(String originalText, String sortedText, int order) {
        this.originalText = originalText;
        this.sortedText = sortedText;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Anagram{" +
                ", originalText='" + originalText + '\'' +
                ", sortedText='" + sortedText + '\'' +
                ", order=" + order +
                '}';
    }
}
