/**
给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 

 

 示例 1： 

 
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
 

 示例 2： 

 
输入：n = 1
输出：[[1]]
 

 

 提示： 

 
 1 <= n <= 20 
 
 Related Topics 数组 矩阵 模拟 👍 548 👎 0

*/
package leetcode.editor.cn;

import java.util.Arrays;

//Java：螺旋矩阵 II
public class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        // TO TEST
        int n = 6;
        int[][] res = new int[n][n];
        res = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        //初始化正方形
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int number = 1;
        while (left < right && up < down){
            // 从左向右填充,左闭右开区间
            for (int y = left; y < right; y++) {
                res[up][y] = number;
                number += 1;
            }
            // 从上到下，左闭右开区间
            for(int x = up; x < down; x++){
                res[x][right] = number;
                number += 1;
            }
            // 从右到左，左闭右开区间
            for(int y = right; y > left; y--){
                res[down][y] = number;
                number += 1;
            }
            // 从下到上，左闭右开区间
            for(int x = down; x > up; x--){
                res[x][left] = number;
                number += 1;
            }
            left += 1;
            right -= 1;
            up += 1;
            down -= 1;
        }
        if (n % 2 != 0){
            res[n / 2][n / 2] = number;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}