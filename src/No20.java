public class No20 {
    public static boolean isValid(String s) {
        char a;
        //int i = 0;
        StringBuffer s1 = new StringBuffer();
        if(s.length() == 0) return true;
        for(int i = 0; i < s.length();i++){
            a = s.charAt(i);
            switch (a){
                case '(':
                    s1.append('(');
                    System.out.println("case '(':"+s1);
                    break;
                case '[':
                    s1.append('[');
                    System.out.println(" case '[':"+s1);
                    break;
                case  '{':
                    s1.append('{');
                    System.out.println("case  '{':"+s1);
                    break;
                case ')':
                    if(s1.length()==0 || s1.charAt(s1.length()-1)=='[' || s1.charAt(s1.length()-1)=='{')
                        return false;
                    if(s1.charAt(s1.length()-1)=='(')
                        s1.deleteCharAt(s1.length()-1);
                    System.out.println("case ')':"+s1);
                    break;
                case ']':
                    if(s1.length()==0 || s1.charAt(s1.length()-1)=='(' || s1.charAt(s1.length()-1)=='{')
                        return false;
                    if(s1.charAt(s1.length()-1)=='[')
                        s1.deleteCharAt(s1.length()-1);
                    System.out.println("case ']':"+s1);
                    break;
                case '}':
                    if(s1.length()==0 || s1.charAt(s1.length()-1)=='(' || s1.charAt(s1.length()-1)=='[')
                        return false;
                    if(s1.charAt(s1.length()-1)=='{')
                        s1.deleteCharAt(s1.length()-1);
                    System.out.println("case '}':"+s1);
                    break;
            }
        }

        if(s1.length()==0) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()]"));
    }
}
