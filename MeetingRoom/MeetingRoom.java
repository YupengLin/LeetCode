package MeetingRoom;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval v1, Interval v2) {
				 return v1.start - v2.start;
			}
		});
		
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		MeetingRoom mr = new MeetingRoom();
		Interval v1 = new Interval(0, 30);
		Interval v2 = new Interval(5, 10);
		Interval v3 = new Interval(15, 20);
		Interval[] intervals = {v1, v2, v3};
		System.out.println(mr.canAttendMeetings(intervals));
	}
}
