package xianxingbiao;

public class LinearQueueDemo {
    public static void main(String[] args) {

    }
}

/**
 * 队列的顺序存储结构类
 */
class LinearQueue{
    int[] datas;
    int maxSize;
    int front;
    int rear;
    public LinearQueue(int maxsize){
        this.maxSize = maxsize;
        datas = new int[maxsize];
        front = 0;
        rear = 0;
    }

    /**
     * 计算队列长度的函数
     * @return 队列的长度
     */
    public int getQueueLen(){
        int length = (rear - front + maxSize) % maxSize;
        return length;
    }

    /**
     * 插入函数,在尾部插入,(rear + 1) % maxSize 为尾部下一个位置
     * @param data 要插入的数据
     * @return 成功返回true,失败返回false
     */
    public boolean insert(int data){
        if((rear+1)%maxSize==front){
            System.out.println("队列已满，不能再插入");
            return false;
        }
        datas[rear] = data;
        rear = (rear + 1) % maxSize;
        return true;
    }

    /**
     * 删除函数,在头部删除,(front + 1) % maxSize 为头部下一个位置
     * @return
     */
    public boolean delete(){
        if(rear == front){
            System.out.println("队列为空，不能删除");
            return false;
        }
        front = (front + 1) % maxSize;
        return true;
    }

}
