package xianxingbiao;

import java.util.Arrays;

public class LinearlistDemo {

    public static void main(String[] args) {
        Linearlist ll = new Linearlist(10);
        //ll.insert(0,1);
        ll.insert(1,1);
        ll.insert(2,2);
        ll.insert(3,3);
        ll.insert(2,4);
        ll.insert(3,5);
        ll.insert(6,6);
        System.out.println(ll.length);
        System.out.println(Arrays.toString(ll.elementData));
        ll.remove(1);
        System.out.println(ll.length);
        System.out.println(Arrays.toString(ll.elementData));
    }
}

/**
 * 线性表类
 */
class Linearlist{
    int[] elementData;
    int length;
    Linearlist(int Maxsize){
        elementData = new int[Maxsize];
        length = 0;
    }

    /**
     *
     * @param index 要查询的值的下标
     * @return 如果查询的值不存在，返回-1；存在，返回查询值的索引
     */
    public int getelemetData(int index){
        if(index<0||index>length){
            System.out.println("下标错误");
        }
        return elementData[index];
    }

    /**
     *
     * @param index 插入的数据要插入的第几个位置
     * @param data 要插入的数据
     * @return 插入成功返回true;失败返回false;
     */
    public boolean insert(int index,int data){
        if(length>=elementData.length){
            System.out.println("线性表已满");
            return false;
        }
        if(index<=0||index>=length+2){
            System.out.println("请插入到正确的位置");
            return false;
        }
        if(index==length+1) {
            elementData[index-1] = data;
            length++;
            return true;
        }
        for(int i=length;i>=index;i--){
            elementData[i] = elementData[i-1];
        }
        elementData[index-1] = data;
        length++;
        return true;
    }

    /**
     * 删除指定位置上数据的函数
     * @param index 要删除的第几个数据
     * @return 删除成功返回true;失败返回false;
     */
    public boolean remove(int index){
        if(index<=0||index>length){
            System.out.println("请输入正确数据");
            return false;
        }
        if(index==length){
            elementData[length-1]=0;
            length--;
            return true;
        }
        for(int i=index;i<length;i++){
            elementData[i-1] = elementData[i];
        }
        elementData[length-1]=0;
        length--;
        return true;
    }

}
