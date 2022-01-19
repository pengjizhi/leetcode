/**
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 


 返回滑动窗口中的最大值。 

 

 示例 1： 

 
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

 示例 2： 

 
输入：nums = [1], k = 1
输出：[1]
 

 示例 3： 

 
输入：nums = [1,-1], k = 1
输出：[1,-1]
 

 示例 4： 

 
输入：nums = [9,11], k = 2
输出：[11]
 

 示例 5： 

 
输入：nums = [4,-2], k = 2
输出：[4] 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 
 Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1356 👎 0

*/
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口最大值
public class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        // TO TEST
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue{
        Deque<Integer> deque = new ArrayDeque<>();
        //弹出元素，判断当前数值是否等于队列出口数值，相等则弹出
        void poll(int val){
            if (!deque.isEmpty() && deque.peek() == val){
                deque.poll();
            }
        }
        //添加元素，保证为单调递减，这样每次排在出口的就是最大的
        void add(int val){
            while (!deque.isEmpty() && val > deque.peekLast()){
                deque.pollLast();
            }
            deque.add(val);
        }
        //得到最大值
        int peek(){
            return deque.peek();
        }

    }
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] res = new int[len];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int index = 0;
        res[index] = myQueue.peek();
        index += 1;
        for (int i = k; i < nums.length; i++) {
            myQueue.add(nums[i]);
            myQueue.poll(nums[i - k]);
            res[index] = myQueue.peek();
            index += 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}