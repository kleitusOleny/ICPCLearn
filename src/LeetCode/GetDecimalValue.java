package LeetCode;


import java.util.Map;
import java.util.Stack;

/*
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 */
public class GetDecimalValue {
    
    public int getDecimalValue(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int sum= 0;
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int fac = 0;
        while (!stack.isEmpty()){
            int cur = stack.pop();
            
            sum += cur* Math.pow(2,fac++);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        GetDecimalValue t = new GetDecimalValue();
        ListNode test = new ListNode(1,new ListNode(1,new ListNode(0,new ListNode(1))));
        
        System.out.println(t.getDecimalValue(test));
        String[] n = new String[]{"CAB"};
        System.out.println(n[0].indexOf('A'));
    }
}
