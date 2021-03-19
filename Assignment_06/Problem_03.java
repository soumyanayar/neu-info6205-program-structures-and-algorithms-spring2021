package Assignment_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem_03 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int numValue = nums[i] + nums[j] + nums[k];
                if (numValue < 0) {
                    j++;
                } else if (numValue > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
