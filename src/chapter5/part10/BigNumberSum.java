package chapter5.part10;

/**
 * Created by weimengshu on 2018/10/20.
 */
public class BigNumberSum {

    /**
     * 大整数求和
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        int[] arrayA = new int[maxLength+1];
        for(int i=0; i< bigNumberA.length(); i++){
            arrayA[i] = bigNumberA.charAt(bigNumberA.length()-1-i) - '0';
        }
        int[] arrayB = new int[maxLength+1];
        for(int i=0; i< bigNumberB.length(); i++){
            arrayB[i] = bigNumberB.charAt(bigNumberB.length()-1-i) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength+1];
        //3.遍历数组，按位相加
        for(int i=0; i<result.length; i++){
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            //判断是否进位
            if(temp >= 10){
                temp = temp-10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if(!findFirst){
                if(result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }
}
