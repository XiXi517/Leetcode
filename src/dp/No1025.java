package dp;

public class No1025 {
    public static boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        dp[1] = false;
        for (int i = 2;i < dp.length;i++){
            //i的公约数数组
            //int[] gy = new int[i/2 + 1];
            for (int j = 1;j < i;j++){
                if(i % j == 0 && dp[i-j] == false){
                    dp[i] = true;
                    break;
                }
            }
            /*System.out.print(i+" "+dp[i]+" gy:");
            for (int c:gy){
                System.out.print(c+",");
            }
            System.out.println();*/
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(9));
    }
}
