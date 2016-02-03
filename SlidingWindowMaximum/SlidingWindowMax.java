package SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by linyupeng on 9/20/15.
 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] windowMax = new int[nums.length - k + 1];
        if(nums.length == 0) {
            return windowMax;
        }
        deque orderQueue = new deque();
        for(int i = 0; i < nums.length; i++) {
            orderQueue.add(nums[i]);
            if(i >= k) {
                orderQueue.remove(nums[i - k]);
            }
            if(i >= k - 1) {
                windowMax[i - (k - 1)] = orderQueue.max();
            }

        }

        return windowMax;
    }
    private static class deque {
        Deque<Integer> orderQueue = new LinkedList<Integer>();
        public void add(int i) {
            while(!orderQueue.isEmpty() && orderQueue.peekLast() < i) {
                orderQueue.removeLast();
            }
            orderQueue.addLast(i);
        }

        public int max() {
            return orderQueue.peek();
        }
        public void remove(int i) {
            if(!orderQueue.isEmpty() && orderQueue.peek() == i) {
                orderQueue.removeFirst();
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int[] ans = new SlidingWindowMax().maxSlidingWindow(nums, 1);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ;");
        }
    }
}

