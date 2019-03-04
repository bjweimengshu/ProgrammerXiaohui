package chapter5.part6;

/**
 * Created by weimengshu on 2018/7/13.
 */

public class MaxSortedDistance {

    public static int getMaxSortedDistance(int[] array){

        //1.得到数列的最大值和最小值
        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        //如果max和min相等，说明数组所有元素都相等，返回0
        if(d == 0){
            return 0;
        }

        //2.初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for(int i = 0; i < bucketNum; i++){
            buckets[i] = new Bucket();
        }

        //3.遍历原始数组，确定每个桶的最大最小值
        for(int i = 0; i < array.length; i++){
            //确定数组元素所归属的桶下标
            int index = ((array[i] - min)  * (bucketNum-1) / d);
            if(buckets[index].min==null || buckets[index].min>array[i]){
                buckets[index].min = array[i];
            }
            if(buckets[index].max==null || buckets[index].max<array[i]){
                buckets[index].max = array[i];
            }
        }

        //4.遍历桶，找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i=1; i<buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }

    /**
     * 桶
     */
    private static class Bucket {
        Integer min;
        Integer max;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance(array));
    }
}
