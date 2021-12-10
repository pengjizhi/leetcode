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

import java.lang.annotation.Target;
import java.util.Arrays;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] nums = {3,3,3,4,5,6,6,6};
        int target = 3;
        int[] result = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(result));

        int testLeft = solution.binaryLeft(nums, target);
        System.out.println("testLeft:" + testLeft);
        System.out.println("------");
        int testRight = solution.binaryRight(nums, target);
        System.out.println("testRight:" + testRight);

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

        int leftBorder = binaryLeft(nums, target);
        int rightBorder = binaryRight(nums, target);
        return new int[] {leftBorder, rightBorder};

    }


    public int binaryLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left >> 1);
            if (target <= nums[mid]){
                right = mid;
            } else {
                left  = mid + 1;
            }
        }
        // 得到左侧逼近的极限index后，如果这个index在极限左侧，这个index可能不是nums里面的数字，需要判断这个index的值和target是否相等
        // 如果这个index在极限右侧，需要判断index是否超出数组
        if (right == nums.length){
            return -1;
        }
        return  nums[right] == target ? right : -1;
    }

    public int binaryRight(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left >> 1);
            if (target >= nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //如果极限右侧超出数组范围，需要判断left - 1是否等于最右边的那个值
        //如果极限右侧在最左边，left == 0，说明
        // if (target >= nums[mid]){
        //                left = mid + 1;
        //            }
        //就没进去过，否则left至少要加个1，left == 0足以证明target不在数组中，在数组左侧，直接返回-1
        if (left == 0){
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * public int[] searchRange(int[] nums, int target) {
     *         if (nums == null || nums.length == 0){
     *             return new int[] {-1, -1};
     *         }
     *         if (nums.length == 1){
     *             if (target == nums[0]){
     *                 return new int[] {0 ,0};
     *             } else {
     *                 return new int[] {-1, -1};
     *             }
     *         }
     *         int left = 0, right = nums.length;
     *         int resStart = -1, resEnd = -1;
     *         while (left < right){
     *             int mid = left + (right - left >> 1);
     *             if (target < nums[mid]){
     *                 right = mid;
     *             } else if (target > nums[mid]){
     *                 left = mid + 1;
     *             } else {
     *                 resStart = mid;
     *                 resEnd = mid;
     *                 while (resEnd + 1 < nums.length && nums[resEnd] == nums[resEnd + 1]){
     *                     resEnd += 1;
     *                 }
     *                 while (resStart - 1 >= 0 && nums[resStart] == nums[resStart - 1]){
     *                     resStart -= 1;
     *                 }
     *                 break;
     *             }
     *         }
     *         return new int[] {resStart, resEnd};
     *     }
     *
     *     以上方法可以ac，但是以上方法的思路在于，用二分法找到目标数字后，向两侧扩展，假如最坏情况，则数组全部都是同一个数
     *     扩展的时间复杂度可以到达O（n）
     *     因此，要想让时间复杂度降低到O（logn），只能采用两次二分，一次找最左边，一次找最右边。
     */
}