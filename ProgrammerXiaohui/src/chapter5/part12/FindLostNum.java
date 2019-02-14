package chapter5.part12;

/**
 * Created by weimengshu on 2018/10/10.
 */
public class FindLostNum {

    public static int[] findLostNum(int[] array) {
        //用于存储两个出现奇数次的整数
        int result[] = new int[2];
        //第一次整体异或
        int xorResult = 0;
        for(int i=0;i<array.length;i++){
            xorResult^=array[i];
        }
        //如果异或结果为0，说明输入数组不符合题目
        if(xorResult == 0){
            return null;
        }
        //确定两个整数的不同位，以此来做分组
        int separator = 1;
        while (0==(xorResult&separator)){
            separator<<=1;
        }
        //第二次分组异或
        for(int i=0;i<array.length;i++){
            if(0==(array[i]&separator)){
                result[0]^=array[i];
            }else {
                result[1]^=array[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0] + "," + result[1]);
    }
}
