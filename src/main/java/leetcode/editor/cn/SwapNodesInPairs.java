/**
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 

 

 示例 1： 

 
输入：head = [1,2,3,4]
输出：[2,1,4,3]
 

 示例 2： 

 
输入：head = []
输出：[]
 

 示例 3： 

 
输入：head = [1]
输出：[1]
 

 

 提示： 

 
 链表中节点的数目在范围 [0, 100] 内 
 0 <= Node.val <= 100 
 
 Related Topics 递归 链表 👍 1175 👎 0

*/
package leetcode.editor.cn;

import java.util.List;

//Java：两两交换链表中的节点
public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        // TO TEST
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        //定义一个虚拟节点指向头节点
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;


            cur = cur.next.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}