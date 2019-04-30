package chapter1.part2;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class TimeComplex {

    void eat1(int n){
        for(int i=0; i<n; i++){;
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("吃一寸面包");
        }
    }

    void eat2(int n){
        for(int i=n; i>1; i/=2){
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("等待一天");
            System.out.println("吃一半面包");
        }
    }

    void eat3(int n){
        System.out.println("等待一天");
        System.out.println("吃一个鸡腿");
    }

    void eat4(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.println("等待一天");
            }
            System.out.println("吃一寸面包");
        }
    }
}
