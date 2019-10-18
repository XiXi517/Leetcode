package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class util {
    //二叉树链式存储
    public static TreeNode creatTree(int[] arr){
        if (arr == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        childTree(arr,1,root,true);
        childTree(arr,2,root,false);
        return root;
    }

    public static void childTree(int[] arr, int childIndex, TreeNode father,boolean left){
        if (childIndex < arr.length){
            if (arr[childIndex] < 0) return;
            if (left){
                father.left = new TreeNode(arr[childIndex]);
                childTree(arr,(childIndex * 2)+1,father.left,true);
                childTree(arr,(childIndex * 2)+2,father.left,false);
            }else {
                father.right = new TreeNode(arr[childIndex]);
                childTree(arr,(childIndex * 2)+1,father.right,true);
                childTree(arr,(childIndex * 2)+2,father.right,false);
            }
        }
        else {
            return;
        }
    }
}
