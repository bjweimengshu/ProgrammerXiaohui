package chapter5.part3;

import java.util.Stack;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class MinStack {

    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 入栈操作
     * @param element  入栈的元素
     */
    public void push(int element) {
        mainStack.push(element);
        //如果最小栈为空，直接让下标0入栈
        if(minStack.isEmpty()){
            minStack.push(0);
            return;
        }
        if(element < getMin()){
            minStack.push(mainStack.size()-1);
        }
    }

    /**
     * 出栈操作
     */
    public Integer pop() {
        Integer element = mainStack.pop();
        //如果出栈元素的下标和最小栈栈顶值相等，最小栈出栈
        if(mainStack.size() == minStack.lastElement()){
            minStack.pop();
        }
        return element;
    }

    /**
     * 获取栈的最小元素
     */
    public Integer getMin(){
        if(mainStack.isEmpty()){
            return null;
        }
        return mainStack.get(minStack.lastElement());
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(3);
        stack.push(8);
        stack.push(5);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
