/**
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 

 

 示例 1： 

 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
 

 示例 2： 

 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

 

 限制： 

 
 0 <= matrix.length <= 100 
 0 <= matrix[i].length <= 100 
 

 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
 Related Topics 数组 矩阵 模拟 👍 325 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：顺时针打印矩阵
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
        int[][] matrix = null;
        int[] res = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[] {};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int count = 0;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        while (left < right && up < down){
            for (int y = left; y < right; y++){
                res[count] = matrix[up][y];
                count += 1;
            }
            for (int x = up; x < down; x++){
                res[count] = matrix[x][right];
                count += 1;
            }

            for (int y = right; y > left; y--){
                res[count] = matrix[down][y];
                count += 1;
            }
            for (int x = down; x > up; x--){
                res[count] = matrix[x][left];
                count += 1;
            }
            left += 1;
            right -= 1;
            up += 1;
            down -= 1;
        }
        if (up == down){
            for (int i = left; i <= right; i++){
                res[count] = matrix[up][i];
                count += 1;
            }
        }else if (left == right){ // 走了一边就不能走另外一边，防止在m和n相等且同为奇数的情况下，重复添加中心元素
            for (int i = up; i <= down; i++) {
                res[count] = matrix[i][left];
                count += 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}