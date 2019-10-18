package Tree;

import java.util.ArrayDeque;
/*给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/

public class No100 {
    /*public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
        }
    }*/


    //有两种情况，1.两个都为空 2.两个都不为空且值相等
    public boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        else return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!check(p,q)) return false;

        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addFirst(p);
        deqQ.addFirst(q);

        while(!deqP.isEmpty()){
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p,q)) return false;
            if (p != null){
                if (!check(p.left,q.left)) return false;
                if (p.left != null){
                    deqP.addFirst(p.left);
                    deqQ.addFirst(q.left);
                }
                if (!check(p.right,q.right)) return false;
                if (p.right != null){
                    deqP.addFirst(p.right);
                    deqQ.addFirst(q.right);
                }
            }
        }
        return true;
    }

}
