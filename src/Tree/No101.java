package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static Tree.util.creatTree;

/*给定一个二叉树，检查它是否是镜像对称的。*/
//广度
public class No101 {
    //判断两个节点是否相等
    /*public static boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        else return false;
    }*/
    //迭代
    /*public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        if (!check(p,q)) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        if (p != null){
            queue.add(p);
            System.out.println("入 "+p.val);
            queue.add(q);
            System.out.println("入 "+q.val);
        }
        while (!queue.isEmpty()){
             p = queue.poll();
            System.out.println("出 "+p.val);
             q = queue.poll();
            System.out.println("出 "+q.val);
             if (!check(p.left,q.right)) return false;
             if (p.left != null && q.right !=null){
                 queue.add(p.left);
                 System.out.println("入 "+p.left.val);
                 queue.add(q.right);
                 System.out.println("入 "+q.right.val);
             }
            if (!check(p.right,q.left)) return false;
            if (p.right != null && q.left != null){
                queue.add(p.right);
                System.out.println("入 "+p.right.val);
                queue.add(q.left);
                System.out.println("入 "+q.left.val);
            }
        }
        return true;
    }*/

    //递归
    /*public static boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        if (!check(root.left,root.right)) return false;
        else {
             return isMerror(root.left,root.right);
        }
    }

    public static boolean isMerror(TreeNode p,TreeNode q){
        if (!check(p,q)) return false;
        if (p != null && q !=null){
            if (!check(p.left,q.right)) return false;
            if (!check(p.right,q.left)) return false;
            else return (isMerror(p.left,q.right) && isMerror(p.right,q.left));
        }
        return true;
    }*/

    //官方迭代
    /*public static boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isMerror(root,root);
    }

    public static boolean isMerror(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val)
                && isMerror(p.left,q.right)
                && isMerror(p.right,q.left);
    }*/

    public static boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,3,4,5,5,4,7,-1,8,6,9,8,-1,7};
        TreeNode root = creatTree(arr);
        System.out.println(isSymmetric(root));
        System.out.println();
    }
}
