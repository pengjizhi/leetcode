/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length, t.length <= 10⁵
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1496 👎 0
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最小覆盖子串
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // TO TEST
        /**
         *  * 输入：s = "ADOBECODEBANC", t = "ABC"
         *  * 输出："BANC"
         */
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = "a", t1 = "a";
        String s2 = "a", t2 = "aa";
        String s3 = "abc", t3 = "a";
        String res = solution.minWindow(s, t);
        System.out.println(res);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            /**
             * 对于新加入的字符s[i],如果hs[s[i]] <= ht[s[i]]，说明当前新加入的字符s[i]是必需的，且还未到达字符串t所要求的数量。
             * 我们还需要事先定义一个distance变量， cnt维护的是s字符串[j,i]区间中满足t字符串的元素的个数，记录相对应字符的总数。新加入的字符s[i]必需，则cnt++。
             *这个distance很关键，其衡量了两个map之间的差异性
             * 其实是先找到了一个大的合法区间，然后不断去向左缩小或者向右扩展这个合法区间，寻找最小临界值，distance的值只会被更新一次，满足条件后，再也不会变了
             */
            if (s.length() < t.length()) {
                return "";
            }
                Map<Character, Integer> map_s = new HashMap<>();
                Map<Character, Integer> map_t = new HashMap<>();
                for (int i = 0; i < t.length(); i++) {
                    map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);
                }
                String res = "";
                int len = Integer.MAX_VALUE;
                int distance = 0;
                int left = 0, right = 0;
                while (right < s.length()){
                    map_s.put(s.charAt(right), map_s.getOrDefault(s.charAt(right), 0) + 1);
                    if (map_t.containsKey(s.charAt(right)) && map_s.get(s.charAt(right)) <= map_t.get(s.charAt(right))){
                        distance += 1;
                    }
                    while (left <= right && (!map_t.containsKey(s.charAt(left)) || map_s.get(s.charAt(left)) > map_t.get(s.charAt(left)))) {
                        map_s.put(s.charAt(left), map_s.get(s.charAt(left)) - 1);
                        left += 1;
                    }
                    if (distance == t.length() && right - left + 1 < len){
                        len = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                    right += 1;
                }
                return res;
            }
    }
//leetcode submit region end(Prohibit modification and deletion)
        /**        这是个人没看参考答案，写出来的最朴素的解法，但是时间复杂度比较高，花费时间最多的地方在于，每次滑动窗口里面的元素一变，马上就要和t的hashmap进行重新比对，重复性操作太多
         *          但是也没想出来有什么快速的方法可以比对一下，后来发现官方解法采用了一个distance衡量两个map之间的差异，值得学习
         *         public String minWindow(String s, String t) {
         *             Map<String, Integer> map_t = new HashMap<>();
         *             for (int i = 0; i < t.length(); i++) {
         *                 if (map_t.containsKey(t.substring(i, i + 1))) {
         *                     map_t.put(t.substring(i, i + 1), map_t.get(t.substring(i, i + 1)) + 1);
         *                 } else {
         *                     map_t.put(t.substring(i, i + 1), 1);
         *                 }
         *             }
         *             int left = 0, right = 0;
         *             int subLen = 0;
         *             int resLen = Integer.MAX_VALUE;
         *             int resLeft = 0, resRight = 0;
         *             Map<String, Integer> map_s = new HashMap<>();
         *             boolean flag = false;
         *             while (right < s.length()) {
         *                 if (map_s.containsKey(s.substring(right, right + 1))) {
         *                     map_s.put(s.substring(right, right + 1), map_s.get(s.substring(right, right + 1)) + 1);
         *                 } else {
         *                     map_s.put(s.substring(right, right + 1), 1);
         *                 }
         *
         *                 while (isSatisfMap(map_s, map_t)){
         *                     flag = true;
         *                     subLen = right - left + 1;
         *                     if (resLen > subLen){
         *                         resLen = subLen;
         *                         resLeft = left;
         *                         resRight = right;
         *                     }
         *                     if (left == right){
         *                         break;
         *                     }
         *                     map_s.put(s.substring(left, left + 1), map_s.get(s.substring(left, left + 1)) - 1);
         *                     left += 1;
         *                     while (left <= right && !map_t.containsKey(s.substring(left, left + 1))){
         *                         map_s.put(s.substring(left, left + 1), map_s.get(s.substring(left, left + 1)) - 1);
         *                         left += 1;
         *                     }
         *                 }
         *                 right += 1;
         *             }
         *             return flag == true ? s.substring(resLeft, resRight + 1) : "";
         *
         *         }
         *
         *         public boolean isSatisfMap(Map<String, Integer> map_s, Map<String, Integer> map_t){
         *             if (map_s == null){
         *                 return map_t == null ? true : false;
         *             }
         *             if (map_t == null){
         *                 return true;
         *             }
         *             for (Map.Entry<String, Integer> entry : map_t.entrySet()){
         *                 String temp_t_key = entry.getKey();
         *                 int temp_t_value = entry.getValue();
         *                 if (!map_s.containsKey(temp_t_key) || map_s.get(temp_t_key) < temp_t_value){
         *                     return false;
         *                 }
         *             }
         *             return true;
         *         }
         */

    }