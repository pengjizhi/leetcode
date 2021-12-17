/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一
 * 棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * <p>
 * <p>
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= fruits.length <= 10⁵
 * 0 <= fruits[i] < fruits.length
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 132 👎 0
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：水果成篮
public class FruitIntoBaskets {
    public static void main(String[] args) {
        Solution solution = new FruitIntoBaskets().new Solution();
        // TO TEST
        int[] nums1 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int[] nums2 = {1, 2, 3, 2, 2};
        int res = solution.totalFruit(nums2);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] fruits) {
            //本题题意实在是难以理解，可以理解为本题在求只包含两个元素的最长子序列
            /**
             *  1. 滑动窗口，另外需要建立一个hashset保存窗口中每个元素和出现的次数，当元素次数为0时，remove
             *  2. 当hashset的size > 2时，进入循环，left一直往前进，每前进一次，hashset的该v对应-1
             */
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0, right = 0;
            int res = 0;
            int subLen = 0;
            while (right < fruits.length) {
                // 字典创建
                if (map.containsKey(fruits[right])) {
                    map.put(fruits[right], map.get(fruits[right]) + 1);
                } else {
                    map.put(fruits[right], 1);
                }

                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left += 1;
                }
                //这个循环结束，说明此时的left和right是相对满足条件的可能解
                subLen = right - left + 1;
                res = res < subLen ? subLen : res;
                right += 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}