/*给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。*/
package Tree;

import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No104 {
    //递归
    /*public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int lhight = maxDepth(root.left);
        int rhight = maxDepth(root.right);
        return Math.max(lhight,rhight) + 1;
    }*/

    //迭代 深度优先遍历
    public static int maxDepth(TreeNode root){
        LinkedList<Pair<TreeNode,Integer>> stack = new LinkedList<>();
        stack.add(new Pair<>(root,1));
        int maxhight = 0;
        while (!stack.isEmpty()){
            Pair pire = stack.pollFirst();
            TreeNode p = (TreeNode) pire.getKey();
            int currentH = (Integer) pire.getValue();
            if (p == null) continue;
            maxhight = Math.max(maxhight,currentH);
            stack.add(new Pair<>(p.left,currentH + 1));
            stack.add(new Pair<>(p.right,currentH + 1));

        }
        return maxhight;

        /*LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> stack1 = new LinkedList<>();
        stack.add(root);
        stack1.add(1);
        int maxhight = 0;
        while (!stack.isEmpty()){
            TreeNode p = stack.pollFirst();
            int currentH = stack1.pollFirst();
            if (p == null) continue;
            maxhight = Math.max(maxhight,currentH);
            stack.add(p.left);
            stack1.add(currentH + 1);
            stack.add(p.right);
            stack1.add(currentH + 1);
        }
        return maxhight;*/
    }


    public static void main(String[] args) {
        int[] arr = {3,9,20,-1,-1,15,7};
        TreeNode root = util.creatTree(arr);
        System.out.println(maxDepth(root));
    }
}
