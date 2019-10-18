## No.104 二叉树的最大深度

## 1.题目描述

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

**说明:** 叶子节点是指没有子节点的节点。



## 2.思路

递归：求根节点的左右子树的深度最大值 + 1，递归

出口：左右子树都为空，return 0；



迭代：栈，深度遍历，maxhight——最大深度  currenthight——当前节点深度

根节点入栈，

判断栈空

​	节点出栈

​	节点为空 continue；

​	节点不为空的话 左右子树入栈且其 currenthight + 1

​	maxhight = Math.max(maxhight,currentH);





## 3.迭代算法

~~~java
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
~~~

关键点：

​	用currenthight记录当前节点的深度，在每次子节点入栈时递增

​	maxhight记录最大深度，每次和currenthight比较

~~~java
 int currentH = (Integer) pire.getValue();

  maxhight = Math.max(maxhight,currentH);
  stack.add(new Pair<>(p.left,currentH + 1));
  stack.add(new Pair<>(p.right,currentH + 1));
~~~



## 4.递归算法

~~~java
public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int lhight = maxDepth(root.left);
        int rhight = maxDepth(root.right);
        return Math.max(lhight,rhight) + 1;
    }
~~~

关键点：

出口

~~~java
 if (root == null) return 0;
~~~

递归的体现

~~~java
int lhight = maxDepth(root.left);
int rhight = maxDepth(root.right);
~~~

深度的计算：

~~~java
return Math.max(lhight,rhight) + 1;
~~~

