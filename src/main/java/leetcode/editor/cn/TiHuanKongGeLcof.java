/**
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 

 

 示例 1： 

 输入：s = "We are happy."
输出："We%20are%20happy." 

 

 限制： 

 0 <= s 的长度 <= 10000 
 Related Topics 字符串 👍 193 👎 0

*/
package leetcode.editor.cn;
//Java：替换空格
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        // TO TEST
        String s = "we are happy";
        String res = solution.replaceSpace(s);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        /**
         * 其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作
         */
        if (s == null || s.length() == 0){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("  ");
            }
        }
        if (sb.length() == 0){
            // 说明没有空格
            return s;
        }
        int left = s.length() - 1;
        s += sb.toString();
        int right = s.length() - 1;

        char[] ch = s.toCharArray();
        while (left < right){
            if (ch[left] != ' '){
                ch[right] = ch[left];
            } else {
                ch[right] = '0';
                ch[right - 1] = '2';
                ch[right - 2] = '%';
                right -= 2;
            }
            left -= 1;
            right -= 1;
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}