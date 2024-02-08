package leetcode;

import java.util.PriorityQueue;

public class JobScheduling {
    public JobScheduling() {

    }
    class Job implements Comparable<Job>{
        int start;
        int end;
        int profit;
        
        public Job() {

        }

        public Job(int profit, int start, int end){
            this.profit = profit;
            this.start = start;
            this.end = end;
           
        }

        @Override
        public int compareTo(Job job) {
            return this.end - job.start;
        }
    }

    public int maximumProfitInJobScheduling(int[] profit, int[] start, int[] end) {
       
        // HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Job> pq = new PriorityQueue<>();
        for(int i = 0; i < profit.length; i++) {
            Job job = new Job(profit[i], start[i], end[i]);
            pq.offer(job);

        }

        return 0;
    }


    public static void main(String[] args) {
        JobScheduling job = new JobScheduling();
        int[] profit = {10, 20, 50, 70, 30, 40};
        int[] start = {1, 3, 4, 6, 8, 10, 12};
        int[] end = {2, 4, 6, 8, 9, 11, 13};
        int ans = job.maximumProfitInJobScheduling(profit, start, end);
        System.out.println(ans);
    }

    
}
