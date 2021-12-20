/**
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 

 

 示例 1： 

 
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
 

 示例 2： 

 
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

 

 提示： 

 
 m == matrix.length 
 n == matrix[i].length 
 1 <= m, n <= 10 
 -100 <= matrix[i][j] <= 100 
 
 Related Topics 数组 矩阵 模拟 👍 934 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：螺旋矩阵
public class SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        // TO TEST
        int[][] matrix = {{1,2,3,4,5},{5,6,7,8,9},{9,10,11,12,13}};
        List<Integer> res = new ArrayList<>();
        res = solution.spiralOrder(matrix);
        System.out.println(res);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = n - 1, up = 0, down = m - 1;
        while (left < right && up < down){
            for (int y = left; y < right; y++){
                res.add(matrix[up][y]);
            }
            for (int x = up; x < down; x++){
                res.add(matrix[x][right]);
            }

            for (int y = right; y > left; y--){
                res.add(matrix[down][y]);
            }
            for (int x = down; x > up; x--){
                res.add(matrix[x][left]);
            }
            left += 1;
            right -= 1;
            up += 1;
            down -= 1;
        }
        if (up == down){
            for (int i = left; i <= right; i++){
                res.add(matrix[up][i]);
            }
        }else if (left == right){ // 走了一边就不能走另外一边，防止在m和n相等且同为奇数的情况下，重复添加中心元素
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}