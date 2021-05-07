package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  2 - 3 - 4
 *  1 - 1 - 2
 *
 *  1
 *
 *  2,4
 *
 *  1 1 - 2
 *  1 2 1 - 3
 *
 *
 *
 *  0,3 -> 0 1 2    -> i = 0 -> 0+3 -> 3
 *  1,3 -> 1 2 3    -> i = 1 -> 1+3 -> 4
 *
 *  0,1 -> 0
 *  1,1 -> 1
 *
 *
 */

class Apples{
    int count;
    int numberOfDays;
    int index;

    public Apples(int apple, int day, int i) {
        this.count = apple;
        this.numberOfDays = day;
        this.index = i;
    }
}

public class MaxApples {
    public static void main(String[] args) {

        MaxApples maxApples = new MaxApples();
        int i = maxApples.eatenApples(
                new int[]{0,4,2,0,1,0,5,6,6,6,1,5,0,1,3,2},
                new int[]{0,3,3,0,2,0,4,4,1,11,2,8,0,1,2,4});
        System.out.println("args = " + i);

    }
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<Apples> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> Math.abs(a.numberOfDays))
        );

        if (queue.isEmpty() && apples.length>0 && apples[0] != 0){
            queue.add(new Apples(apples[0] - 1 ,days[0],0));
            ans++;
        }
        for (int i = 1; i < apples.length; i++) {

            queue.add(new Apples(apples[i] ,i + days[i],i));

            while (!queue.isEmpty()){
                Apples peek = queue.peek();
                if (peek.count == 0 || isRotten(i,peek)){
                    queue.poll();
                } else{
                    System.out.println("index" + peek.index);
                    peek.count--;
                    ans++;
                    break;
                }
            }
        }

        int length = apples.length ;

        while (!queue.isEmpty()){
            Apples peek = queue.peek();
            if (peek.count == 0 || isRotten(length,peek)){
                queue.poll();
            } else{
                System.out.println("index" + peek.index);
                peek.count--;
                ans++;
                length++;
            }
        }

        return ans;
    }

    private boolean isRotten(int index , Apples apple){
        return apple.numberOfDays<=index;
    }
}
