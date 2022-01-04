/**
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的
三元组。 

 注意：答案中不可以包含重复的三元组。 

 

 示例 1： 

 
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
 

 示例 2： 

 
输入：nums = []
输出：[]
 

 示例 3： 

 
输入：nums = [0]
输出：[]
 

 

 提示： 

 
 0 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 
 Related Topics 数组 双指针 排序 👍 4153 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        int[] nums = {0,1,-1,1,2,-1,-2};
        List<List<Integer>> res = new ArrayList<>();
        res = solution.threeSum(nums);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 这道题可以采用hash表解决，但是由于不能包含重复的三元组，在去重时不好操作，同时细节比较多，很难直接写出bug-free的code
         * 可以采用双指针的方法解决，首先将数组排序，i即为遍历坐标，left为i+1，right为length-1
         * 回过来想，两数之和能不能用双指针？题目要求返回index，而本类需要采用排序，才能让left和right移动，因此两数之和假如让返回实际对值可以用双指针
         */
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 排序后第一个都大于0，就不可能凑成三元组
            if (nums[i] > 0) {
                return res;
            }
            //开始对i去重复
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] < 0){
                    left += 1;
                } else if (nums[i] + nums[left] + nums[right] > 0){
                    right -= 1;
                } else {
                    //从数组构造array可以这么构造
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 在这里要再次去重
                    while (left < right && nums[left] == nums[left + 1]){
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}