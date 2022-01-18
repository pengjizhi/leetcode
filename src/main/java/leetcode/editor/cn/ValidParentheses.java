/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 

 有效字符串需满足： 

 
 左括号必须用相同类型的右括号闭合。 
 左括号必须以正确的顺序闭合。 
 

 

 示例 1： 

 
输入：s = "()"
输出：true
 

 示例 2： 

 
输入：s = "()[]{}"
输出：true
 

 示例 3： 

 
输入：s = "(]"
输出：false
 

 示例 4： 

 
输入：s = "([)]"
输出：false
 

 示例 5： 

 
输入：s = "{[]}"
输出：true 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由括号 '()[]{}' 组成 
 
 Related Topics 栈 字符串 👍 2890 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：有效的括号
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
        String s = "[][]()()([{}])";
        boolean res = solution.isValid(s);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        /**
         * 碰到左括号，就把相应的右括号入栈，很聪明
         * 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
         * 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符，也就是匹配不上，类似于【）。所以return false
         * 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false
         */
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                deque.push(')');
            } else if (ch == '['){
                deque.push(']');
            } else if (ch == '{'){
                deque.push('}');
            } else if (deque.isEmpty() || ch != deque.peek()){
                //分别对应，第三种情况，第二种情况
                return false;
            } else {
                //匹配上了，弹出
                deque.pop();
            }
        }
        //对应第一种情况，看遍历完后stack里面还有没有值，如果有，说明原始左侧有多余括号
        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}