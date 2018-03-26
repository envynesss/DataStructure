package string;

public class test {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1==s2);

        student stu1 = new student("Merry",20);
        student stu2 = new student("Merry",22);
        System.out.println(stu1==stu2);
        System.out.println(stu1.equals(stu2));
    }
}

class student{
    String name;
    int id;
    public student(String name,int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return this==obj;
    }
}
