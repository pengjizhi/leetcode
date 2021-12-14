/**
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 

 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 

 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 

 

 示例 1： 

 
输入：x = 4
输出：2
 

 示例 2： 

 
输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 

 

 提示： 

 
 0 <= x <= 2³¹ - 1 
 
 Related Topics 数学 二分查找 👍 841 👎 0

*/
package leetcode.editor.cn;
//Java：Sqrt(x)
public class Sqrtx{
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        // TO TEST
        int testNumber = 2;
        int res = solution.mySqrt(testNumber);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int mySqrt(int x){
            // 二分法
            if (x == 1) {
                return 1;
            }
            double left = 0;
            double right = x;
            double mid = left + (right - left) / 2;
            while (Math.abs(mid * mid - x) > 0.01){
                if (mid * mid < x){
                   left = mid;
                } else if (mid * mid > x){
                    right = mid;
                } else {
                    return (int)mid;
                }
                mid = left + (right - left) / 2;
            }
            return (int)mid;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 这个方法是牛顿法，求根为：x1 = (x0 + a / x0) / 2;
     *     public int mySqrt(int x) {
     *         //Newton methos
     *         double startX = 1.0;
     *         while (Math.abs(startX * startX - x) > 0.1){
     *             startX = (startX + x / startX) / 2;
     *         }
     *         return (int) startX;
     *     }
     */
}