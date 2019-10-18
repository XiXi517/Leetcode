# No.1025 除数博弈

## 1. 题目描述

爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 ***0 < x < N*** 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。



示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。

**提示： ** ***1 <= N <= 1000***



## 2.思路

我的思路：

​	记 dp[N] 为黑板上数字为N的情况下,Alice的输赢情况（当为N时，先手的输赢情况）

​	 如果Alice取了数字 x , 那么显然 dp[N] 与 dp[N -x] 输赢情况相反。x 可以取的值很多（N的约数），**只要dp[N -xi] 中任意一个为 False**, 那么 dp[N] 肯定为True, 否则 dp[N] 肯定为False



数学题思路：

​	数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
	无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
	因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
	N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。

​	***综述，判断N是奇数还是偶数，即可得出最终结果！**



## 3. 我的解法

~~~java
public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 2;i < dp.length;i++){
            //i的约数数组
            int[] gy = new int[i/2 + 1];
            for (int j = 1;j < gy.length;j++){
                if(i % j == 0 ) gy[j] = j;
                else gy[j] = 0;
                //只要dp[N -xi] 中任意一个为 False, 那么 dp[N] 肯定为True
                if(gy[j] != 0 && dp[i-gy[j]] == false){ 
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
~~~



**优化寻找约数的部分**：不用数组记录每一个约数，只要 j 满足是约数且 dp[N -xi] 为false，及可以得 dp[N] 为True，跳出内循环

~~~java
for (int i = 2;i < dp.length;i++){
       //i的公约数数组
       for (int j = 1;j < i;j++){
            if(i % j == 0 && dp[i-j] == false){
                 dp[i] = true;
                 break;
            }
       }
}
~~~



## 4.数学解法

~~~java
public boolean divisorGame(int N) {
        if(N % 2 ==0) return true;
        else return false;
    }
~~~

