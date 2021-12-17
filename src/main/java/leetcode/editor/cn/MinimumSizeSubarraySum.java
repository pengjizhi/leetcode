/**
给定一个含有 n 个正整数的数组和一个正整数 target 。 

 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
如果不存在符合条件的子数组，返回 0 。 

 

 示例 1： 

 
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 

 示例 2： 

 
输入：target = 4, nums = [1,4,4]
输出：1
 

 示例 3： 

 
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
 

 

 提示： 

 
 1 <= target <= 10⁹ 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁵ 
 

 

 进阶： 

 
 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
 
 Related Topics 数组 二分查找 前缀和 滑动窗口 👍 854 👎 0

*/
package leetcode.editor.cn;

import java.util.logging.Level;

//Java：长度最小的子数组
public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // TO TEST
        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        int target = 15;
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 双指针构造滑动窗口
        //可以理解为一个向前蠕动的毛毛虫，头向前进，尾向前缩，二者保持异步过程，整体向前进
        //思路在于，当窗口内的值大于target，尾部一直向前缩，直到窗口内的值小于target，头再前进
        // 时间复杂度是O(N),因为每个元素进来一次出去一次，相当于O（2N）
        int start = 0;
        int end = 0;
        int res = Integer.MAX_VALUE; // 这个是用来存最后的长度的
        int subLen = 0;
        int sum = 0;
        while (end < nums.length){
            sum += nums[end];
            while (sum >= target){
                subLen = end - start + 1;
                if (res > subLen){
                    res = subLen; // res逐渐缩小
                }
                sum -= nums[start]; // 尾巴向前缩
                start += 1;
            }
            end += 1;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     *   普普通通的两个for循环，时间复杂度高
     *     public int minSubArrayLen(int target, int[] nums) {
     *         int res = Integer.MAX_VALUE;
     *         for (int i = 0; i < nums.length; i++) {
     *             int sum = 0;
     *             int subLen = 0;
     *             for (int j = i; j < nums.length; j++) {
     *                 sum += nums[j];
     *                 if (sum >= target){
     *                     subLen = j - i + 1;
     *                     res = subLen < res ? subLen : res;
     *                     break;
     *                 }
     *             }
     *         }
     *         return res == Integer.MAX_VALUE ? 0 : res;
     *     }
     */
}