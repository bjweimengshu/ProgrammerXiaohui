package chapter2.part3;

/**
 * Created by weimengshu on 2018/8/24.
 */
public class MyQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity){
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element  入队的元素
     */
    public void enQueue(int element) throws Exception {
        if((rear+1)%array.length == front){
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear =(rear+1)%array.length;
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front =(front+1)%array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output(){
        for(int i=front; i!=rear; i=(i+1)%array.length){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();
    }
}
