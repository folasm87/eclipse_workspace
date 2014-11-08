package net.multivision.serializable;
 
import java.io.Serializable;
 
public class Dog implements Serializable{
       
        /**
         *
         */
        private static final long serialVersionUID = 5844902975969902238L;
        private String name;
        private int age;
        private transient boolean collar;
        /*Create a Dog class that implements serializable, and Dog HAS-A Collar that does NOT implement
         * serializable. Assuming that you can't just make Collar serializable, create 3 dog objects. with
         * collar objects, and serialize and deserialize these objects without throwing an exception.
         * */
       
        public Dog(String name, int age, boolean collar){
               
                this.name = name;
                this.age = age;
                this.collar = collar;
               
                if (this.collar){
                        System.out.println(this.name + " is a Dog aged " + this.age + ". It has a collar.");
                }else{
                        System.out.println(this.name + " is a Dog aged " + this.age + ". It does not have a collar.");
                }
               
               
               
        }
       
        public void print(){
                System.out.println("Dog's name: " + this.name + "\n Dog's age: " + this.age + "\n Has collar: " + this.collar);
        }
       
       
}