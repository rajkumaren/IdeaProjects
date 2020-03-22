package compare;

import jdk.jfr.DataAmount;

public class Comparable {



}



class Student implements java.lang.Comparable<Student> {

    String name;
    int age;
    String address;
    String section;
    String standard;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }



    @Override
    public int compareTo(Student o) {

    }
}