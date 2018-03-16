package xianxingbiao;

public class LinkListDemo {
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
        return currentNode;
    }

    /**
     *
     * @param index 在第index位置上插入新的节点
     * @param newNode 要插入的节点
     * @return 成功true,失败false
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
                System.out.println("该节点不存在");
                return false;
            }

        }
        newNode.nextNode = currentNode;
        beforecurrentNode.nextNode = newNode;
        return true;
    }
}


