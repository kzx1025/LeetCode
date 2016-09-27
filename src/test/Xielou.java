package test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by iceke on 16/9/21.
 */
public class Xielou {
    static class Student{
        private String name;
        public Student(String name){
            this.name = name;
        }
        public void setName(String name){
            this.name = name;
        }
    }

    public static void main(String[] args)
    {
        Set<Student> set = new HashSet<Student>();
        Student s1 = new Student("Jack");
        Student s2 = new Student("Mary");
        Student s3 = new Student("Eason");

        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println(set.size());//3
        s2.setName("Jackson"); //修改属性，此时s2元素对应的hashcode值发生改变
        set.remove(s2);        // remove不掉，造成内存泄漏
        set.add(s2);           // 添加成功

        System.out.println(set.size());//4
    }
}
