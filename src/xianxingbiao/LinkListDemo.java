package xianxingbiao;

import java.util.Random;

public class LinkListDemo {
    public static void main(String[] args) {
        LinkList ll = new LinkList(3);
        ll.printAll();
        ll.insert(3,10);
        System.out.println("插入后。。。。");
        ll.printAll();
        System.out.println("删除后。。。。");
        ll.remove(1);
        ll.printAll();
        System.out.println("清空后。。。。");
        ll.clear();
        ll.printAll();
    }
}

class Node{
    int data;
    Node nextNode;
    Node(int data){
        this.data = data;
    }

    public String toString(){
        return " data " + this.data;
    }
}

/**
 * 线性表的链式结构
 */

class LinkList{
    int length;
    Node headNode;
    Node rearNode;

    /**
     * 初始化链表的函数
     * @param len 初始化链表的长度
     */
    public LinkList(int len){
        Random random = new Random();
        length = 1;
        int i = 2;
        headNode = new Node(1);
        rearNode = headNode;
        while (length<len){
            Node currentNode = new Node(i++);
            rearNode.nextNode = currentNode;
            rearNode = currentNode;
            length++;
        }
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
     * 单链表的读取,时间复杂度为O(n).
     * @param index 查找的第几个节点
     * @return 存在返回该节点对象，不存在返回null
     */
    public Node find(int index){
        int i = 1;
        Node currentNode = headNode;
        if(index<=0){
            System.out.println("节点位置大于0,请重新输入");
            return null;
        }
        while(i<index){
            if(currentNode!=null){
                i++;
                currentNode = currentNode.nextNode;
            }else{
                System.out.println("该节点不存在");
                return null;
            }
        }
        if(currentNode!=null){
            System.out.println(currentNode);
            return currentNode;
        }else {
            System.out.println("该节点不存在");
            return null;
        }
    }

    /**
     *
     * @param index 在第index位置上插入新的节点
     * @param data 要插入的节点的data
     * @return 插入成功true,失败false
     */
    public boolean insert(int index,int data){
        Node newNode = new Node(data);
        int i = 1;
        Node currentNode = headNode;
        Node beforecurrentNode = headNode;
        if(index<=0){
            System.out.println("节点位置大于0,请重新输入");
            return false;
        }
        if(i==index){
            newNode.nextNode = headNode;
            headNode = newNode;
            length++;
            return true;
        }
        while(i<index){
            if(currentNode!=null){
                i++;
                beforecurrentNode = currentNode;
                currentNode = currentNode.nextNode;
            }else{
                System.out.println("该节点与原链表有间隔,无法插入");
                return false;
            }

        }
        newNode.nextNode = currentNode;
        beforecurrentNode.nextNode = newNode;
        length++;
        return true;
    }

    /**
     *
     * @param index 要删除的元素位置
     * @return 删除成功true,失败false
     */
    public boolean remove(int index){
        int i = 1;
        Node currentNode = headNode;
        Node beforecurrentNode = headNode;
        if(index==1){
            headNode = headNode.nextNode;
            length--;
            return true;
        }
        while(i<index){
            if(currentNode!=null){
                i++;
                beforecurrentNode = currentNode;
                currentNode = currentNode.nextNode;
            }else{
                System.out.println("该节点不存在，无法删除");
                return false;
            }
        }
        if(currentNode!=null){
            beforecurrentNode.nextNode = currentNode.nextNode;
            length--;
            return true;
        }else {
            System.out.println("该节点不存在，无法删除");
            return false;
        }
    }

    /**
     * 清空链表函数
     */
    public void clear(){
        Node currentNode = headNode;
        Node tempNode;
        while(currentNode!=null){
            currentNode = currentNode.nextNode;
            headNode = currentNode;
        }
        length = 0;
    }
}


