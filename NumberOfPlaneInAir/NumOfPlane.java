package NumberOfPlaneInAir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumOfPlane {
	public int countOfAirplanes(List<Interval> airplanes) {
		
		List<Point> flights = new ArrayList<>();
		for(Interval airplane : airplanes) {
			flights.add(new Point(airplane.start, 1));
			flights.add(new Point(airplane.end, 0));
		}
		Collections.sort(flights, new Comparator<Point>() {
			@Override
			public int compare(Point p0, Point p1) {
				if(p0.time == p1.time) return p0.status - p1.status;
				return p0.time - p1.time;
			}	
		});
		int maxCount = 0;
		int count = 0;
		for(Point flight : flights) {
			if(flight.status == 1) {
				count++;
			} else {
				count--;
			}
			maxCount = Math.max(count, maxCount);
		}
		return maxCount;
	}
	
	class Point {
		int time;
		int status;
		public Point(int time, int status) {
			this.time = time;
			this.status = status;
		}
	}
	
	public static void main(String[] args) {
		NumOfPlane np = new NumOfPlane();
		List<Interval> plane = new ArrayList<>();
		plane.add(new Interval(1, 10));
		plane.add(new Interval(2, 3));
		plane.add(new Interval(5, 8));
		plane.add(new Interval(4, 7));
		
		System.out.println(np.countOfAirplanes(plane));
	}
}
