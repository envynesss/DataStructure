package xianxingbiao;

public class LinkStackDemo {
    public static void main(String[] args) {
        LinkStack lsk = new LinkStack();
        lsk.push(1);
        lsk.push(2);
        lsk.push(3);
        System.out.println("链表长："+lsk.length);
        lsk.pop();
        lsk.pop();
        System.out.println("链表长："+lsk.length);
        lsk.push(4);
        System.out.println("链表长："+lsk.length);
    }
}

/**
 * 栈的链式存储结构实现
 */
class LinkStack{
    Node topNode;
    int length;
    public LinkStack(){
        length = 0;
    }

    /**
     * 入栈函数
     * @param data 入栈的数据
     * @return 入栈成功返回true
     */
    public boolean push(int data){
        Node newNode = new Node(data);
        if(topNode==null){
            topNode = newNode;
            length++;
            System.out.println(data + " 入栈");
            return true;
        }else{
            newNode.nextNode = topNode;
            topNode = newNode;
            length++;
            System.out.println(data + " 入栈");
            return true;
        }
    }

    /**
     *
     * @return 出栈的数据,栈空时返回-1
     */
    public int pop(){
        if(length<=0){
            System.out.println("栈已空，请进行其它操作");
            return -1;
        }else{
            int data = topNode.data;
            topNode = topNode.nextNode;
            length--;
            System.out.println(data + " 出栈");
            return data;
        }
    }
}
