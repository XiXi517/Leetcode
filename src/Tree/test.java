package Tree;

import static Tree.No101.*;
import static Tree.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,5,5,4,-1,-1,8,9,9,8};
        TreeNode root = creatTree(arr);
        System.out.println(isSymmetric(root));
        System.out.println();
    }
}
