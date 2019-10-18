public class No58 {
    //从头开始遍历
    /*public static int lengthOfLastWord(String s) {
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
    }*/

    //从尾开始遍历
    /*public static int lengthOfLastWord(String s){
        int len = 0;
        for (int i = s.length()-1; i >= 0;i--){
            if (s.charAt(i) != ' '){
                len++;
            }
            if (len > 0 && s.charAt(i) == ' ')
                return len;
        }
        return len;
    }*/

    //从尾开始遍历，用后索引-前索引
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

    public static void main(String[] args) {
        String s = " a sd  ";
        System.out.println(lengthOfLastWord(s));
    }

}
