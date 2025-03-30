package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = false;
        if (p != null && q != null) {
            if (p.val == q.val) {
                res = isSameTree(p.left, q.right) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }else if (p == null && q == null){
            return true;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode t21 = new TreeNode(1,new TreeNode(2),null);
        TreeNode t22 = new TreeNode(1,null,new TreeNode(2));
        TreeNode t31 = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode t32 = new TreeNode(1,new TreeNode(1),new TreeNode(2));
        
        System.out.println(isSameTree(t1,t1));
        System.out.println(isSameTree(t21,t22));
        System.out.println(isSameTree(t31,t32));
    }
}
