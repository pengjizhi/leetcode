/**
给定两个数组，编写一个函数来计算它们的交集。 

 

 示例 1： 

 输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
 

 示例 2： 

 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4] 

 

 说明： 

 
 输出结果中的每个元素一定是唯一的。 
 我们可以不考虑输出结果的顺序。 
 
 Related Topics 数组 哈希表 双指针 二分查找 排序 👍 456 👎 0

*/
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：两个数组的交集
public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 本题主要考察hashset的使用
        // 如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费！
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i : nums1){
            set1.add(i);
        }
        for (int i : nums2){
            if (set1.contains(i)){
                resSet.add(i);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for (int i : resSet){
            res[index] = i;
            index += 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}