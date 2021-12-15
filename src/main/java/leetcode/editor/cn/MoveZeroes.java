/**
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 

 示例: 

 输入: [0,1,0,3,12]
输出: [1,3,12,0,0] 

 说明: 

 
 必须在原数组上操作，不能拷贝额外的数组。 
 尽量减少操作次数。 
 
 Related Topics 数组 双指针 👍 1341 👎 0

*/
package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // TO TEST
        int[] nums = {1,0,1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                int temp  = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow += 1;
            }
            fast += 1;

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}