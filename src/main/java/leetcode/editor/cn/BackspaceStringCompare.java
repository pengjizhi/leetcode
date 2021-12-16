/**
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。 

 如果相等，返回 true ；否则，返回 false 。 

 注意：如果对空文本输入退格字符，文本继续为空。 

 

 示例 1： 

 
输入：s = "ab#c", t = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
 

 示例 2： 

 
输入：s = "ab##", t = "c#d#"
输出：true
解释：s 和 t 都会变成 “”。
 

 示例 3： 

 
输入：s = "a##c", t = "#a#c"
输出：true
解释：s 和 t 都会变成 “c”。
 

 示例 4： 

 
输入：s = "a#c", t = "b"
输出：false
解释：s 会变成 “c”，但 t 仍然是 “b”。 

 

 提示： 

 
 1 <= s.length, t.length <= 200 
 s 和 t 只含有小写字母以及字符 '#' 
 

 

 进阶： 

 
 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
 

 
 Related Topics 栈 双指针 字符串 模拟 👍 349 👎 0

*/
package leetcode.editor.cn;
//Java：比较含退格的字符串
public class BackspaceStringCompare{
    /**
     * 准备两个指针 ii, jj 分别指向 SS，TT 的末位字符，再准备两个变量 skipSskipS，skipTskipT 来分别存放 SS，TT 字符串中的 # 数量。
     * 从后往前遍历 SS，所遇情况有三，如下所示：
     * 2.1 若当前字符是 #，则 skipSskipS 自增 11；
     * 2.2 若当前字符不是 #，且 skipSskipS 不为 00，则 skipSskipS 自减 11；
     * 2.3 若当前字符不是 #，且 skipSskipS 为 00，则代表当前字符不会被消除，我们可以用来和 TT 中的当前字符作比较。
     *若对比过程出现 SS, TT 当前字符不匹配，则遍历结束，返回 falsefalse，若 SS，TT 都遍历结束，且都能一一匹配，则返回 truetrue
     */
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        // TO TEST
        String s = "a##c";
        String t = "#a#c";
        System.out.println(solution.backspaceCompare(s, t));

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        int skip1 = 0;
        int skip2 = 0;

        while (index1 >= 0 || index2 >= 0) {
            while (index1 >= 0) {
                if (s.charAt(index1) == '#') {
                    skip1 += 1;
                    index1 -= 1;
                } else if (skip1 > 0) {
                    skip1 -= 1;
                    index1 -= 1;
                } else {
                    break;
                }
            }

            while (index2 >= 0) {
                if (t.charAt(index2) == '#') {
                    skip2 += 1;
                    index2 -= 1;
                } else if (skip2 > 0) {
                    skip2 -= 1;
                    index2 -= 1;
                } else {
                    break;
                }
            }

            if (index1 >= 0 && index2 >= 0){
                if (s.charAt(index1) != t.charAt(index2)){
                    return false;
                }
            } else {
                if (index1 >= 0 || index2 >= 0){
                    return false;
                }
            }
            index1 -= 1;
            index2 -= 1;


        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}