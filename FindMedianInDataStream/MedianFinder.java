package FindMedianInDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // right side
		int len = 0;
		
		public void addNum(int num) {
			
			if(len % 2 == 0) {
				max.add(num);
			} else {
				max.add(num);
				min.add(max.poll());
			}
			len++;
			if(len >= 2 && max.peek() > min.peek()) {
				max.add(min.poll());
				min.add(max.poll());
			}
			
		}
		
		public double findMedian() {
			if(len % 2 == 0) {
				return ((double)max.peek() + (double)min.peek()) / 2.0;
			} else {
				return (double) max.peek();
			}
		}
	
	//PriorityQueue<Integer>  m
	public static void main(String[] args) {
		PriorityQueue<Integer> min = new PriorityQueue<>();
		min.offer(1);
		min.offer(2);
		min.offer(10);
		min.offer(3);
		//System.out.println(min.peek());
		min.poll();
		//System.out.println(min.peek());
		
		MedianFinder mfinder = new MedianFinder();
		mfinder.addNum(1);
		mfinder.addNum(2);
		System.out.println(mfinder.findMedian());
		mfinder.addNum(3);
		System.out.println(mfinder.findMedian());
	}
}
