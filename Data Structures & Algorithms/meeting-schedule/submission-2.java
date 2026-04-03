/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) {
        return true;
    }
        Collections.sort(intervals,(a,b)->{
            if(a.end!= b.end)
            return a.end - b.end;
            return a.start - b.start;
        });
        int count = 1;
        int prevEnd = intervals.get(0).end;

        for(int i =1; i<intervals.size();i++){
            if(intervals.get(i).start >= prevEnd){
                count++;
                prevEnd = intervals.get(i).end;
            }
        }

    if(count == intervals.size()){
        return true;
    }
else{
    return false;
}
    }
}
