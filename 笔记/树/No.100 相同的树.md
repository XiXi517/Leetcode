# No.100 相同的树

## 1.题目描述

给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
               / \       / \
             2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
              /             \
            2                2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
               / \       / \
             2   1    1   2

        [1,2,1],   [1,1,2]

输出: false



## 2.思路

1. 递归方法：

   判断 p，q 是否为空

   判断 p，q 值是否相等

   递归调用对子结点（p，q 的左右子树）做相同操作

   

2. 迭代方法：从根节点开始，每次将当前结点从队列中弹出，进行递归中的判断，如果满足则将子节点压入队列

   对根节点进行**是否全部为空判断**

   对**根节点**进行**方法一**判断

   根节点不为空——入队

   判断队列非空——出队

   ​	**当前结点*进行**方法一**判断

   ​	当前结点非空——**左结点**进行**方法一**判断

   ​					左节点非空——左节点入队

   ​				——**右结点**进行**方法一**判断

   ​					右节点非空——右节点入队



## 3.递归方法

~~~java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
}
~~~



关键点：递归的部分体现其左右子树

~~~java
return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
~~~



## 4.迭代方法

~~~java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
~~~



关键点：

 	1. 每一个结点入队的条件：非空，值相等
 	2. 基本判断条件（每一个节点都要判断）：两个节点是否相等（全为空 或 全不为空值相等）