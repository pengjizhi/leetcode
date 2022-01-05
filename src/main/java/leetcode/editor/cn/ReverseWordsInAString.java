/**
给你一个字符串 s ，逐个翻转字符串中的所有 单词 。 

 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 

 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。 

 说明： 

 
 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。 
 翻转后单词间应当仅用一个空格分隔。 
 翻转后的字符串中不应包含额外的空格。 
 

 

 示例 1： 

 
输入：s = "the sky is blue"
输出："blue is sky the"
 

 示例 2： 

 
输入：s = "  hello world  "
输出："world hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 

 示例 3： 

 
输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 

 示例 4： 

 
输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"
 

 示例 5： 

 
输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"
 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 包含英文大小写字母、数字和空格 ' ' 
 s 中 至少存在一个 单词 
 

 
 

 

 进阶： 

 
 请尝试使用 O(1) 额外空间复杂度的原地解法。 
 
 Related Topics 双指针 字符串 👍 421 👎 0

*/
package leetcode.editor.cn;
//Java：翻转字符串里的单词
public class ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // TO TEST
        String s = "   fly  in  the! sky!";
        String res = solution.reverseWords(s);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        /**
         * 1.去掉多余的空格
         * 2.全部反转字符串
         * 3.反转每个单词
         */
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();

    }

        /**
         * 去掉多余的空格
         * @param s
         * @return
         */
    private StringBuilder removeSpace(String s){
        int left = 0, right = s.length() - 1;
        while (s.charAt(left) == ' ') left += 1;
        while (s.charAt(right) == ' ') right -= 1;
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' ' || s.charAt(left - 1) != ' '){
                sb.append(c);
            }
            left += 1;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb){
        int left = 0, right = 0;
        while (left < sb.length()){
            while (right < sb.length() && sb.charAt(right) != ' '){
                right += 1;
            }
            reverseString(sb, left, right - 1);
            // right最后会停在空格处，相当于left再往后移动一位是新的起点
            left = right + 1;
            right = left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}