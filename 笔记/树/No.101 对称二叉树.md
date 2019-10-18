# No.101 对称二叉树

## 1.题目描述

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

​    1

  /   \

  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

​    1

  /   \

  2   2

   \   \

   3    3



## 2.思路

迭代思路：队列  层次遍历

​	***判断对称：队列取节点，对称节点相同，将其对称的子节点入队***

​	1、根节点入队

​	2、判断是否队空，取节点

​	3、p的左子 与 q的右子

​		1）全为空  可

​		2）一个为空  不可

​		3）值不同  不可

​	4、p，q 左右子树对称的入队



递归思路：

​	递归出口：两个节点同为空	出true 

​			   有一个节点为空  出false

 	递归部分：两个节点是否相等

​			   两个节点的4个对称节点是否镜像（递归）

​	  

## 3.迭代解法

我的：

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
public boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        else return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        if (!check(p,q)) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        if (p != null){
            queue.add(p);
            queue.add(q);
        }
        while (!queue.isEmpty()){
             p = queue.poll();
             q = queue.poll();
             if (!check(p.left,q.right)) return false;
             if (p.left != null && q.right !=null){
                 queue.add(p.left);
                 queue.add(q.right);
             }
            if (!check(p.right,q.left)) return false;
            if (p.right != null && q.left != null){
                queue.add(p.right);
                queue.add(q.left);
            }
        }
        return true;
    }
~~~



标准：

~~~java
public boolean isSymmetric(TreeNode root){
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
~~~

关键点：先入队后判断，省去分别判断要两次，代码重复

~~~java
		   TreeNode p = queue.poll();
            TreeNode q = queue.poll();   //取出
            if (p == null && q == null) continue;   //取出后再判断
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            queue.add(p.left);  
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
~~~





## 4.递归解法

我的：

~~~java
public boolean check(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return true;
        else return false;
    }

    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        if (!check(root.left,root.right)) return false;
        else {
             return isMerror(root.left,root.right);
        }
    }

    public boolean isMerror(TreeNode p,TreeNode q){
        if (!check(p,q)) return false;
        if (p != null && q !=null){
            if (!check(p.left,q.right)) return false;
            if (!check(p.right,q.left)) return false;
            else return (isMerror(p.left,q.right) && isMerror(p.right,q.left));
        }
        return true;
    }
~~~



标准：

~~~java
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isMerror(root,root);
    }

    public boolean isMerror(TreeNode p,TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val)
                && isMerror(p.left,q.right)
                && isMerror(p.right,q.left);
    }
~~~

关键点：体现递归的语句

~~~java
return (p.val == q.val)
        && isMerror(p.left,q.right)
        && isMerror(p.right,q.left);
~~~



