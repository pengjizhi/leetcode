/**
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 

 如果数组中不存在目标值 target，返回 [-1, -1]。 

 进阶： 

 
 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
 

 

 示例 1： 

 
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4] 

 示例 2： 

 
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1] 

 示例 3： 

 
输入：nums = [], target = 0
输出：[-1,-1] 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums 是一个非递减数组 
 -10⁹ <= target <= 10⁹ 
 
 Related Topics 数组 二分查找 👍 1334 👎 0

*/
package leetcode.editor.cn;

import java.util.Arrays;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] nums = {3,3};
        int target = 3;
        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }
        if (nums.length == 1){
            if (target == nums[0]){
                return new int[] {0 ,0};
            } else {
                return new int[] {-1, -1};
            }
        }
        int left = 0, right = nums.length;
        int resStart = -1, resEnd = -1;
        while (left < right){
            int mid = left + (right - left >> 1);
            if (target < nums[mid]){
                right = mid;
            } else if (target > nums[mid]){
                left = mid + 1;
            } else {
                resStart = mid;
                resEnd = mid;
                while (resEnd + 1 < nums.length && nums[resEnd] == nums[resEnd + 1]){
                    resEnd += 1;
                }
                while (resStart - 1 >= 0 && nums[resStart] == nums[resStart - 1]){
                    resStart -= 1;
                }
                break;
            }
        }
        return new int[] {resStart, resEnd};


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}