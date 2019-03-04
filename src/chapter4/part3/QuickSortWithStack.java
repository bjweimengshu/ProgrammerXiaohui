package chapter4.part3;

/**
 * Created by weimengshu on 2018/7/13.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortWithStack {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空时结束
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if(param.get("startIndex") <  pivotIndex -1){
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex",  param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex -1);
                quickSortStack.push(leftParam);
            }
            if(pivotIndex + 1 < param.get("endIndex")){
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 分治（单边循环法）
     * @param arr     待交换的数组
     * @param startIndex    起始下标
     * @param endIndex    结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int mark = startIndex;

        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
