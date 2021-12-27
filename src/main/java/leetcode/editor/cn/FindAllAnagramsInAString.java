/**
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 

 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 

 

 示例 1: 

 
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 

 示例 2: 

 
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 

 

 提示: 

 
 1 <= s.length, p.length <= 3 * 10⁴ 
 s 和 p 仅包含小写字母 
 
 Related Topics 哈希表 字符串 滑动窗口 👍 747 👎 0

*/
package leetcode.editor.cn;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // TO TEST
        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> res = new ArrayList<>();
        res = solution.findAnagrams(s, t);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] record = new int[26];
        for (int i = 0; i < p.length(); i++) {
            record[s.charAt(i) - 'a'] += 1;
            record[p.charAt(i) - 'a'] -= 1;
        }
        int differ = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0){
                differ += 1;
            }
        }
        if (differ == 0){
            res.add(0);
        }
        // i所代表的是左边界，i + p.length是右边界
        //注意，i代表的是马上就会去除的字符，i + p.length是马上就会加上的字符
        //比如p有3个字符，那么i和i+p.length是0，3
        //因为一开始的情况在之前已经判断过，所以此时i代表的0，马上会去掉，i+p.length代表的3马上就要加上
        //也就是说任何时候，实际上在滑动窗口的字符，为i到i + p.length - 1中间的字符
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (record[s.charAt(i) - 'a'] == 1){
                differ -= 1;
            } else if (record[s.charAt(i) - 'a'] == 0){
                differ += 1;
            }
            record[s.charAt(i) - 'a'] -= 1;
            if (record[s.charAt(i + p.length()) - 'a'] == -1){
                differ -= 1;
            } else if (record[s.charAt(i + p.length()) - 'a'] == 0){
                differ += 1;
            }
            record[s.charAt(i + p.length()) - 'a'] += 1;

            if (differ == 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}