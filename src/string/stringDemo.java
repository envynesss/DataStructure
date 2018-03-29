package string;

import java.util.Arrays;

public class stringDemo {
    public static void main(String[] args) {
        strindexKPM("abcx","cx",0);
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
                i = i-j+1;// 退回到上次匹配首位的下一位
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
    //abcabcx 求字符串的next值
    public static int[] get_next(String str){
        int str_len = str.length();
        int[] next = new int[str_len];
        next[0] = -1;
        int suffix = 0;  // 后缀
        int prefix = -1;  // 前缀
        while(suffix<str_len-1){
            //若前缀索引为-1或相等，则前缀后缀索引均+1
            if(prefix==-1||str.charAt(prefix)==str.charAt(suffix)){
                suffix++;
                prefix++;
                next[suffix] = prefix;
                /*//改进的地方
                if (str.charAt(prefix) == str.charAt(suffix)) {
                    next[suffix] = next[prefix];
                } else {
                    next[suffix] = prefix;
                }*/
            }else{
                prefix = next[prefix]; // 回溯到next[prefix]
            }
        }
        //System.out.println(Arrays.toString(next));
        return next;
    }

    public static int strindexKPM(String s1,String s2,int pos){
        int len1 = s1.length();
        int len2 = s2.length();
        int suffix = pos;
        int prefix = 0;
        int[] next = get_next(s2);
        while(prefix<len2&&suffix<len1){
            if(prefix==-1||s1.charAt(suffix)==s2.charAt(prefix)){
                suffix++;
                prefix++;

            }else{
                prefix = next[prefix];
            }
        }
        if(prefix==len2){
            System.out.println(suffix-prefix);
            return suffix-prefix;//根据next数组的指示j进行回溯，而i永远不会回溯
        }
        System.out.println("不存在");
        return -1;
    }
}

