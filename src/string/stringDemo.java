package string;

public class stringDemo {
    public static void main(String[] args) {
        strindex1("abcdef","abcdef",0);
    }

    /**
     *
     * @param s1 主字符串
     * @param s2 子字符串
     * @param pos 起始查询位置,从0开始
     */
    public static int strindex(String s1,String s2,int pos){
        int i = pos;
        int len1 = s1.length();
        int len2 = s2.length();
        while(i<len1-len2+1){
            String temp = s1.substring(i,i+len2);
            if(temp.equals(s2)){
                System.out.println(i);
                return i;
            }
            i++;
        }
        System.out.println("不存在");
        return -1;
    }

    /**
     * 朴素的模式匹配算法求字符串匹配问题
     * @param s1
     * @param s2
     * @param pos
     * @return
     */
    public static int strindex1(String s1,String s2,int pos){
        int i = pos;
        int j = 0;
        int len1 = s1.length();
        int len2 = s2.length();

        while(i<len1 && j<len2){
            if(s2.charAt(j)==s1.charAt(i)){
                i++;
                j++;
            }else{
                i = i-j+1;
                j = 0;
            }
        }
        if(j==len2){
            System.out.println(i-j);
            return i-j;
        }
        System.out.println("不存在");
        return -1;
    }

    public static void get_next(String str){
        int str_len = str.length();
        int[] next = new int[str_len];
        next[0] = 0;
        next[1] = 1;
        int i = 0;
        int j = 2;
        while(i<j){
            if(true){
                //TODO:
            }

        }
    }

}

