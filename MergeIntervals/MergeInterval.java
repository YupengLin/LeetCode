package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
	
	
	public List<Interval> merge(List<Interval> intervals) {
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return Integer.compare(a.start, b.start);
			}
		});
		
		List<Interval> afterMerge = new LinkedList<>();
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		System.out.println(intervals.size());
		for(Interval interval : intervals) {
			if(interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				afterMerge.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		afterMerge.add(new Interval(start, end));
		
		return afterMerge;
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		intervals.add(new Interval(19,24));
		intervals.add(new Interval(20,25));
		
		List<Interval> afterMerge = new MergeInterval().merge(intervals);
		
		for(Interval interval : afterMerge) {
			System.out.println(interval.toString());
		}
		
		
		
	}
	
	

}
