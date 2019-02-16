package chapter5.part5;

/**
 * Created by weimengshu on 2018/10/10.
 */
public class PowerOf2 {

    public static boolean isPowerOf2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp*2;
        }
        return false;
    }

    public static boolean isPowerOf2V2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp<<1;
        }
        return false;
    }

    public static boolean isPowerOf2V3(int num) {
        return (num&num-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2V3(32));
        System.out.println(isPowerOf2V3(19));
    }
}
