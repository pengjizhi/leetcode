/**
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 

 在 S 上反复执行重复项删除操作，直到无法继续删除。 

 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 

 

 示例： 

 输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有
 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 

 

 提示： 

 
 1 <= S.length <= 20000 
 S 仅由小写英文字母组成。 
 
 Related Topics 栈 字符串 👍 315 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//Java：删除字符串中的所有相邻重复项
public class RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        // TO TEST
        String s = "abbaca";
        String res = solution.removeDuplicates(s);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        //可以直接拿string 当stack
        StringBuffer sb = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && sb.charAt(top) == c){
                sb.deleteCharAt(top);
                top -= 1;
            } else {
                sb.append(c);
                top += 1;
            }
        }
        return sb.toString();
    }
}

/**     这个是自己建立了一个deque当stack
 *     public String removeDuplicates(String s) {
 *         Deque<Character> deque = new ArrayDeque<>();
 *         for (int i = 0; i < s.length(); i++) {
 *             char ch = s.charAt(i);
 *             if (deque.isEmpty() || deque.peek() != ch){
 *                 deque.push(ch);
 *             } else {
 *                 deque.pop();
 *             }
 *         }
 *         String res = "";
 *         while (!deque.isEmpty()){
 *             res = deque.pop() + res;
 *         }
 *         return res;
 *     }
 */

//leetcode submit region end(Prohibit modification and deletion)

}