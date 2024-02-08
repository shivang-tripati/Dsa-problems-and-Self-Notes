package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;


public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        allPermute(0, nums, ans);
        System.out.println(ans);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        permutaions(new ArrayList<>(), list, res);
        System.out.println(res);
    }



    // first method
     private static  void permutaions(List<Integer> permutation, List<Integer> dt, List<List<Integer>> res ) {
        if(dt.size() == 0) {
            res.add(permutation);
            return;
        }

        for(Integer num : dt) {
            List<Integer> tempP = new ArrayList<>(permutation);
            List<Integer> tempDt = new ArrayList<>(dt);
            tempP.add(num);
            tempDt.remove(num);
            permutaions(tempP, tempDt, res);
        }

     }

    // 2nd method
    public static void allPermute(int index, int[] nums, List<List<Integer>>ans){
        
        if(index == nums.length){
            ArrayList<Integer> tempAns = new ArrayList<>();

            for(int i=0;i<nums.length;i++){
                tempAns.add(nums[i]);
            }
            ans.add(tempAns);
            System.out.println(tempAns);
        }

        for(int i=index;i<nums.length;i++){
            swap(i, index, nums);
            allPermute(index+1, nums, ans);
            swap(i, index, nums);
        }
    }

    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
