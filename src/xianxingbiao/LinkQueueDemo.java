package xianxingbiao;

public class LinkQueueDemo {
    public static void main(String[] args) {
        LinkQueue lq = new LinkQueue();
        lq.insert(1);
        lq.printAll();
        lq.insert(2);
        lq.insert(3);
        lq.printAll();
        lq.delete();
        lq.printAll();
        lq.delete();
        lq.delete();
        lq.printAll();
        lq.delete();

    }
}

class LinkQueue{
    int length;
    Node headNode;
    Node rearNode;
    public LinkQueue(){
        length = 0;
    }

    /**
     * 打印链表所有项
     */
    public void printAll(){
        System.out.println("链表长度:"+length);
        Node currentNode = headNode;
        while(currentNode!=null){
            System.out.println(currentNode);
            currentNode = currentNode.nextNode;
        }
    }

    /**
     * 杀入链式队尾元素
     * @param data 插入的数据
     * @return true or false
     */
    public boolean insert(int data){
        Node newNode = new Node(data);
        if(headNode==null){
            headNode = newNode;
            rearNode = headNode;
            length++;
            return true;
        }
        rearNode.nextNode = newNode;
        rearNode = rearNode.nextNode;
        length++;
        return true;
    }

    /**
     * 删除链式队列元素(头部删除)
     * @return true or false
     */
    public boolean delete(){
        if(length<=0){
            System.out.println("链式队列已空,请进行其他操作");
            return false;
        }
        headNode = headNode.nextNode;
        length--;
        return true;
    }
}
