package xianxingbiao;

import java.util.Random;

public class LinkListDemo {
    public static void main(String[] args) {
        LinkList ll = new LinkList(3);
        ll.find(0);
        ll.find(1);
        ll.find(2);
        ll.find(3);

    }


}

class Node{
    int data;
    Node nextNode;
    Node(int data){
        this.data = data;
    }
}

/**
 * 线性表的链式结构
 */

class LinkList{
    int length;
    Node headNode;
    Node rearNode;

    public LinkList(int len){
        Random random = new Random();
        length = 1;
        headNode = new Node(random.nextInt(100));
        rearNode = headNode;
        while (length<len){
            Node currentNode = new Node(random.nextInt(100));
            rearNode.nextNode = currentNode;
            rearNode = currentNode;
            length++;
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
        while(i<=index){
            if(currentNode!=null){
                i++;
                currentNode = currentNode.nextNode;
            }else{
                System.out.println("该节点不存在");
                return null;
            }
        }
        System.out.println(currentNode);
        return currentNode;
    }

    /**
     *
     * @param index 在第index位置上插入新的节点
     * @param newNode 要插入的节点
     * @return 插入成功true,失败false
     */
    public boolean insert(int index,Node newNode){
        int i = 1;
        Node currentNode = headNode;
        Node beforecurrentNode = headNode;
        while(i<index){
            if(currentNode!=null){
                i++;
                beforecurrentNode = currentNode;
                currentNode = currentNode.nextNode;
            }else{
                System.out.println("该节点不存在,无法插入");
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
        int i = 0;
        Node currentNode = headNode;
        Node beforecurrentNode = headNode;
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
        beforecurrentNode.nextNode = currentNode.nextNode;
        length--;
        return true;
    }
}


