/**
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返
回左旋转两位得到的结果"cdefgab"。 

 

 示例 1： 

 输入: s = "abcdefg", k = 2
输出: "cdefgab"
 

 示例 2： 

 输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
 

 

 限制： 

 
 1 <= k < s.length <= 10000 
 
 Related Topics 数学 双指针 字符串 👍 184 👎 0

*/
package leetcode.editor.cn;
//Java：左旋转字符串
public class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        // TO TEST
        String s = "abcdefg";
        int n = 4;
        String res = solution.reverseLeftWords(s, n);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, s.length() - 1);
        reverseString(sb, 0, s.length() - 1);
        return sb.toString();

    }
    /**
     * 反转字符串闭区间[left,right]
     * @param sb
     * @param left
     * @param right
     */
    public void reverseString(StringBuilder sb, int left, int right){
        while (left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left += 1;
            right -= 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}