package chapter1.part3;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class SpaceComplex {

    void fun1(int n){
        int var = 3;
        //do something
    }

    void fun2(int n){
        int[] array = new int[n];
        //do something
    }

    void fun3(int n){
        int[][] twoDimensionalArray = new int[n][n];
        //do something
    }

    void fun4(int n){
        if(n<=0){
            return;
        }
        fun4(n-1);
        //do something
    }
}
