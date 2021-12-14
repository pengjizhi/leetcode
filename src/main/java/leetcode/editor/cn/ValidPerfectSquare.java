/**
给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 

 进阶：不要 使用任何内置的库函数，如 sqrt 。 

 

 示例 1： 

 
输入：num = 16
输出：true
 

 示例 2： 

 
输入：num = 14
输出：false
 

 

 提示： 

 
 1 <= num <= 2^31 - 1 
 
 Related Topics 数学 二分查找 👍 327 👎 0

*/
package leetcode.editor.cn;
//Java：有效的完全平方数
public class ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // TO TEST
        int testNum = 1;
        boolean result = solution.isPerfectSquare(testNum);
        System.out.println(result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        double x = 1.0;
        while (Math.abs(x * x - num) > 0.01){
            x = (x + num / x) / 2;
        }
        int newX = (int) x;
        if (newX * newX == num){
            return true;
        } else {
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}