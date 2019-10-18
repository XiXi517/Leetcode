import org.junit.Test;
public class HuiWen {

    public boolean isPalindrome(int x) {
        int rev = 0;
        if(x<0 || x % 10 == 0 && x != 0)
            return false;
        while (x > rev){
            rev = x % 10 + rev * 10;
            x = x / 10;
        }
        return (rev == x || rev / 10 == x);
    }

   @Test
    public void testP(){
       System.out.println(isPalindrome(0));
   }

}
