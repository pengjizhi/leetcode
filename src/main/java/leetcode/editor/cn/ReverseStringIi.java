/**
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 

 
 如果剩余字符少于 k 个，则将剩余字符全部反转。 
 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
 

 

 示例 1： 

 
输入：s = "abcdefg", k = 2
输出："bacdfeg"
 

 示例 2： 

 
输入：s = "abcd", k = 2
输出："bacd"
 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由小写英文组成 
 1 <= k <= 10⁴ 
 
 Related Topics 双指针 字符串 👍 230 👎 0

*/
package leetcode.editor.cn;
//Java：反转字符串 II
public class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        // TO TEST
        String s = "abcdefg";
        int k = 2;
        String res = solution.reverseStr(s, k);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        /**
         * 思路为模拟
         * 用i去遍历s，但是i每次+2k
         * 判断i+k是否小于s的length
         */
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            if (i + k <= ch.length){
                reverse(ch, i, i + k - 1);
            } else {
                reverse(ch, i, ch.length - 1);
            }
        }
        return new String(ch);
    }

    public void reverse(char[] ch, int left, int right){
        while (left < right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}