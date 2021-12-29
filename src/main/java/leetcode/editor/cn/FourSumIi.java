/**
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 

 
 0 <= i, j, k, l < n 
 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
 

 

 示例 1： 

 
输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
输出：2
解释：
两个元组如下：
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) +
 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) +
 0 = 0
 

 示例 2： 

 
输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
输出：1
 

 

 提示： 

 
 n == nums1.length 
 n == nums2.length 
 n == nums3.length 
 n == nums4.length 
 1 <= n <= 200 
 -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
 
 Related Topics 数组 哈希表 👍 466 👎 0

*/
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：四数相加 II
public class FourSumIi{
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        // TO TEST
        int[] nums1 = {1,2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0,2};
        int res = solution.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /**
         * 四个数组，先用两个for遍历前两个数组，求出a+b和次数，存入map，
         * 然后用两个for遍历后两个数组，在（c+d）*-1中去map汇总找value的值进行累加
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++){
                if (map.containsKey(-1 * (nums3[i] + nums4[j]))){
                    res += map.get(-1 * (nums3[i] + nums4[j]));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}