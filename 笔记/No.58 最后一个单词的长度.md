# No.58 最后一个单词的长度

## 1.题目

给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

**示例:**

```
输入: "Hello World"
输出: 5
```



## 2.思路

我的思路：从头开始遍历，用 len 记录单词的长度，**当遇到空格时将 len = 0**

​		但是可能最后一个单词后面还有空格，就**保留一个备用的 temp 记录遇到空格前单词的长度**

​                如果**空格后面还有字符，则将 temp中数据清除，与 len 数值保持一致**



进阶思路：从后往前遍历，寻找最后一个不是空格的字符，从这里开始 len++

​		  当遇到字符为空时，返回 len



标准思路：从后往前遍历，寻找最后一个不是空格的字符，用 end （最后一个单词末位字母的索引）记录其索引

​		   将 start（最后一个单词首位字母前一位的索引）赋值为 end

​		   从 end 位置开始向前遍历，直到为空格或遍历到头，将 start--

​		   返回长度为 end-start



## 3.从头开始遍历解法

~~~java
public int lengthOfLastWord(String s) {
        int len = 0;
        int temp = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) != ' '){
                len++;
                temp = len;
            }
            else {
                len = 0;
            }
        }
        if (len != 0) return len;
        else return temp;
    }
~~~



关键点：空格后面还有字符，则将 temp中数据清除，与 len 数值保持一致



## 4.从后开始遍历

~~~java
public static int lengthOfLastWord(String s){
        int len = 0;
        for (int i = s.length()-1; i >= 0;i--){
            if (s.charAt(i) != ' '){
                len++;
            }
            if (len > 0 && s.charAt(i) == ' ')
                return len;
        }
        return len;
~~~

关键点：两个判定条件



## 5.从后开始遍历并记录最后一个单词首尾索引

~~~java
public static int lengthOfLastWord(String s){
        //end >= 0 来代替空字符串判断
        /*if (s.length() == 0) return 0;
        int end = s.length()-1;
        while (s.charAt(end) == ' ' && end > 0){
            end--;
        }*/
        int end = s.length()-1;
        while (s.charAt(end) == ' ' && end >= 0) 
            end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        return end - start;

    }
~~~

关键点：end （最后一个单词末位字母的索引）， start（最后一个单词首位字母前一位的索引）