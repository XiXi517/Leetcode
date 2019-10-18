/*给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j)
  范围内元素的总和，包含 i,  j 两点。*/
public class No303 {

    private int[] data;
    public No303(int[] nums) {
        data = new int[nums.length+1];
        data[0] = 0;
        for(int i = 1;i < data.length;i++){
            data[i] = data[i-1] + nums[i-1] ;
        }
    }

    public int sumRange(int i, int j) {

        return data[j+1] - data[i];

    }

    /*int[] data;
    public No303(int[] nums) {
        this.data = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int m = i;m <= j;m++){
            sum = sum + data[m];
        }
        return sum;

    }*/


}
