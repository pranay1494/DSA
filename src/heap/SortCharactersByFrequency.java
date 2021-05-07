package heap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Data{
    char alphabet;
    int occurence;

    public Data(char alphabet, int occurence) {
        this.alphabet = alphabet;
        this.occurence = occurence;
    }
}
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        String frequencySort = sortCharactersByFrequency.frequencySort("Aabb");
        System.out.println("args = " + frequencySort);
    }

    public String frequencySort(String s) {
        Map<Character,Integer> values = new LinkedHashMap<>();

        PriorityQueue<Data> queue = new PriorityQueue<>((a, b) -> b.occurence-a.occurence);

        for (int i = 0; i < s.length(); i++) {
            if (!values.containsKey(s.charAt(i))){
                values.put(s.charAt(i),1);
            }else {
                Integer integer = values.get(s.charAt(i));
                integer = integer+1;
                values.put(s.charAt(i),integer);
            }
        }
        for (Map.Entry entry:values.entrySet()){
            queue.add(new Data((char)entry.getKey(),(int)entry.getValue()));
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()){
            Data poll = queue.poll();
            for (int i = 0; i < poll.occurence; i++) {
                ans.append(poll.alphabet);
            }
        }
        return ans.toString();
    }
}
