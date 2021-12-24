/**
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 

 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表
中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 

 不允许修改 链表。 

 
 

 

 示例 1： 

 

 
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
 

 示例 2： 

 

 
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
 

 示例 3： 

 

 
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。
 

 

 提示： 

 
 链表中节点的数目范围在范围 [0, 10⁴] 内 
 -10⁵ <= Node.val <= 10⁵ 
 pos 的值为 -1 或者链表中的一个有效索引 
 

 

 进阶：你是否可以使用 O(1) 空间解决此题？ 
 Related Topics 哈希表 链表 双指针 👍 1292 👎 0

*/
package leetcode.editor.cn;

import java.util.List;

//Java：环形链表 II
public class LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // TO TEST
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /**
         * 本题通过数学公示算出，用快慢指针找到交点后，（a + b） * 2 = a + b + c + b;
         * a = c;
         * 找到交点后，同时用两个指针，分别指向起点，和快慢指针相遇的点，等这两个指针相遇，则为交点
         */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                ListNode start = head;
                ListNode intersection = slow;
                while (start != intersection){
                    start = start.next;
                    intersection = intersection.next;
                }
                return start;
            }
        }
        //说明无环
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}