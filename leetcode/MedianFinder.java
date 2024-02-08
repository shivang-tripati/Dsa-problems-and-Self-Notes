package leetcode;

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // to store the lower half
    private PriorityQueue<Integer> minHeap; // to store the upper half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

         if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll()); //maxHeap will always have n+1 no. in case of n is odd. 
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}


