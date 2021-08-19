package merginginterval;

import java.util.*;

public class MinimumMeetingRooms {
    public static void main(String[] args) {
        MinimumMeetingRooms meetingRooms = new MinimumMeetingRooms();
        ArrayList<Meeting> list = new ArrayList<>();
        list.add(new Meeting(4,5));
        list.add(new Meeting(2,3));
        list.add(new Meeting(2,4));
        list.add(new Meeting(3,5));
        System.out.println("args = " + meetingRooms.solve(list));
    }

    int solve(List<Meeting> meetings){
        PriorityQueue<Meeting> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        int ans = 0;

        meetings.sort(Comparator.comparingInt(o -> o.start));

        for (int i = 0; i < meetings.size(); i++) {
            while(!queue.isEmpty() && queue.peek().end <= meetings.get(i).start){
                queue.poll();
            }
            queue.add(meetings.get(i));
            ans = Math.max(ans, queue.size());
        }
        return ans;
    }

}
class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

