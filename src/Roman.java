import org.junit.Test;

import java.util.HashMap;

public class Roman {
    public int romanToInt(String s) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("I",1);
        hashMap.put("IV",3);
        hashMap.put("V",5);
        hashMap.put("IX",8);
        hashMap.put("X",10);
        hashMap.put("XL",30);
        hashMap.put("L",50);
        hashMap.put("XC",80);
        hashMap.put("C",100);
        hashMap.put("CD",300);
        hashMap.put("D",500);
        hashMap.put("CM",800);
        hashMap.put("M",1000);


        /*int i = 1;
        String n = s.substring(0,1);
        int ans = hashMap.get(n);
        while(i < s.length()){
            n = s.substring(i-1,i+1);
            if(hashMap.get(n) == null){
                n = s.substring(i,i+1);
                ans = ans + hashMap.get(n);
                i++;

            }
            else {
                ans = ans + hashMap.get(n);
                i++;
            }
        }*/
        int ans = 0;
        for(int i = 0;i < s.length();i++){
            if(i-1 >= 0 && hashMap.containsKey(s.substring(i-1,i+1))){
                ans = ans + hashMap.get(s.substring(i-1,i+1));
            }
            else
                ans = ans + hashMap.get(s.substring(i,i+1));
        }

        return ans;
    }

    @Test
    public void testRoman(){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
