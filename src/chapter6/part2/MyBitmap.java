package chapter6.part2;

/**
 * Created by weimengshu on 2017/8/10.
 */
public class MyBitmap {

    //每一个word是一个long类型元素，对应64位二进制
    private long[] words;
    //bitmap的位数大小
    private int size;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size-1) + 1)];
    }

    /**
     * 判断bitmap某一位的状态
     * @param bitIndex  位图的第bitIndex位
     */
    public boolean getBit(int bitIndex) {
        if(bitIndex<0 || bitIndex>size-1){
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把bitmap某一位设为真
     * @param bitIndex  位图的第bitIndex位
     */
    public void setBit(int bitIndex) {
        if(bitIndex<0 || bitIndex>size-1){
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位bitmap某一位所对应的word
     * @param bitIndex  位图的第bitIndex位
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitmap bitMap = new MyBitmap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(78));
    }

}
