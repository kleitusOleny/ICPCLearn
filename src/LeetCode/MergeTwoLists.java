package LeetCode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return new ListNode();
        }else {
            if (list1 == null) return list2;
            else if (list2 == null) return list1;
            else {
                ListNode res;
                if (list1.val <= list2.val) {
                    res = new ListNode(list1.val);
                    list1 = list1.next;
                }else {
                    res = new ListNode((list2.val));
                    list2 = list2.next;
                }
                while (list1.next != null || list2.next != null ){
                    if (list1.val < list2.val){
                        res.next = res;
                    }else {
                        res.next = new ListNode(list1.val,res);
                    }
                }
                return res;
            }
        }
    }
}
