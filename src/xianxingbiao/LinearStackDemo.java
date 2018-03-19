package xianxingbiao;

public class LinearStackDemo {

    public static void main(String[] args) {
        LinearStack ls = new LinearStack(2);
        ls.push(1);
        ls.push(2);
        ls.push(3);
        System.out.println(ls.pop());
        ls.push(3);
        System.out.println(ls.pop());
        System.out.println(ls.pop());
    }

}

class LinearStack{
    int maxsize;
    int top;
    int[] data;

    /**
     * 栈的顺序存储结构的构造函数
     * @param maxsize 栈的最大长度
     */
    public LinearStack(int maxsize){
        this.maxsize = maxsize;
        this.top = -1;
        this.data = new int[maxsize];
    }

    /**
     * 入栈函数
     * @param newdata 入栈的数据
     * @return 成功返回true,失败返回false
     */
    public boolean push(int newdata){
        if(top>=maxsize-1){
            System.out.println("栈已满，不能进行插入");
            return false;
        }
        if(top<maxsize-1){
            data[++top] = newdata;
            return true;
        }
        return false;
    }

    /**
     * 出栈函数
     * @return 返回出栈的数据
     */
    public int pop(){
        if(top==-1){
            System.out.println("栈已空，请执行其它操作");
            return -1;
        }
        return data[top--];
    }
}
