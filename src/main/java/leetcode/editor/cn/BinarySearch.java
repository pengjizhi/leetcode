/**
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返
回 -1。 

 
示例 1: 

 输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
 

 示例 2: 

 输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 

 

 提示： 

 
 你可以假设 nums 中的所有元素是不重复的。 
 n 将在 [1, 10000]之间。 
 nums 的每个元素都将在 [-9999, 9999]之间。 
 
 Related Topics 数组 二分查找 👍 526 👎 0

*/
package leetcode.editor.cn;
//Java：二分查找
public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // TO TEST
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;
        int result = solution.search(nums, target);
        System.out.println(result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("error");
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (target < nums[mid]){
                right = mid;
            } else if (target > nums[mid]){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}