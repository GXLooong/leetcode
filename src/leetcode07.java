package src;
public class leetcode07 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
    public static int reverse(int x){
        int result = 0;
        while(x !=0){
            int digit = x % 10;
            int newResult = result * 10 + digit;
            if((newResult - digit)/10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
