/**
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 

 
 

 

 示例 1： 

 
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100] 

 示例 2： 

 
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
 

 

 提示： 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums 已按 非递减顺序 排序 
 

 

 进阶： 

 
 请你设计时间复杂度为 O(n) 的算法解决本问题 
 
 Related Topics 数组 双指针 排序 👍 373 👎 0

*/
package leetcode.editor.cn;

import java.util.Arrays;

//Java：有序数组的平方
public class SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // TO TEST
        int[] nums = {-8,-5,-4,-4,3,-3,0,1,2,3,4,4,5};
        int[] result = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int tempLeft = nums[left] * nums[left];
            int tempRight = nums[right] * nums[right];

            if (tempLeft > tempRight){
                res[i] = tempLeft;
                left += 1;
            } else {
                res[i] = tempRight;
                right -= 1;
            }
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}