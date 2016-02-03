package MeetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRoom2 {
	public int minMeetingRooms(Interval[] intervals) {
			ArrayList<Point> timeSlot = new ArrayList<Point>();
			for(Interval meeting : intervals) {
				timeSlot.add(new Point(meeting.start, 1));
				timeSlot.add(new Point(meeting.end, 0));
			}
	        Collections.sort(timeSlot, new Comparator<Point>(){
	        	public int compare(Point p1, Point p2) {
	        		if(p1.time == p2.time) {
	        			return p1.status - p2.status;
	        		} else {
	        			return p1.time - p2.time;
	        		}
	        	}
	        });
	        int count = 0;
	        int result = Integer.MAX_VALUE;
	       for(Point timePoint : timeSlot) {
	    	   if(timePoint.status == 1) {
	    		   count++;
	    	   } else {
	    		   count--;
	    	   }
	    	   result = Math.max(count, result);
	       }
	        return result;
	}
	
	 class Point{
		int time;
		int status;
		int room;
		Point(int time, int status) {
			this.time = time;
			this.status = status;
		}
	}
	
}
