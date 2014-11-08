package net.multivision.serializable;
import java.io.Serializable;
 
 
//this class is a pojo that stores information about a person
public class Person implements Serializable {
 
       
        /**
         *
         */
        private static final long serialVersionUID = 5573179781062088261L;
        private int age;
        private String name;
        private transient int ssn; //transient means don't serialize this field
        private transient Head myHead;
       
        public Person(int age, String name, int ssn){
                super();
                this.age = age;
                this.name = name;
                this.ssn = ssn;
                System.out.println("Age is: " + this.age + "\nName is: "+ this.name+ ""
                                + "\nSSN is: "+ this.ssn);
        }
       
}