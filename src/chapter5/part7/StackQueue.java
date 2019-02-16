package chapter5.part7;

import java.util.Stack;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class StackQueue {

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 入队操作
     * @param element  入队的元素
     */
    public void enQueue(int element) {
        stackA.push(element);
    }

    /**
     * 出队操作
     */
    public Integer deQueue() {
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    /**
     * 栈A元素转移到栈B
     */
    private void transfer(){
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
    }
}
