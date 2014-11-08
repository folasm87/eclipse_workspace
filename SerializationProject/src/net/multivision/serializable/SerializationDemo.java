package net.multivision.serializable;
 
/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
*/
import java.io.*;
import java.util.*;
 
public class SerializationDemo {
 
        public static void main(String[] args) {
                Person pers = new Person(34, "Rick", 122331413);
                Dog dog1 = new Dog("Grant", 5, true);
                Dog dog2 = new Dog("Jozie", 4, true);
                Dog dog3 = new Dog("Bowzer", 8, false);
               
                //pers.print();
               
                try{
                        //Object(Person) => ObjectOutputStream
                        //=> FileOutputStream => path where file is (String)
                        FileOutputStream fo;
                        fo = new FileOutputStream("src/net/multivision/serializable/output.dat");
                        ObjectOutputStream oos = new ObjectOutputStream(fo);
                        oos.writeObject(pers);
                        oos.close();
                        fo.close();
                        System.out.println("Serialized!");
                       
                        FileInputStream fin =new FileInputStream("src/net/multivision/serializable/output.dat");
                        ObjectInputStream ois = new ObjectInputStream(fin);
                        Object obj = ois.readObject();
                        Person pers2 = (Person) obj;
                       
                }
                catch(FileNotFoundException e){
                        System.out.println("File not found!");
                }catch(IOException e){
                        e.printStackTrace();
                }catch(ClassNotFoundException e){
                        System.out.println("Couldn't find the class");
                }
               
               
                try{
                        FileOutputStream file_out = new FileOutputStream("src\\net\\multivision\\serializable\\dogs.dat");
                        ObjectOutputStream obj_out = new ObjectOutputStream(file_out);
                        obj_out.writeObject(dog1);
                        obj_out.writeObject(dog2);
                        obj_out.writeObject(dog3);
                        obj_out.close();
                        file_out.close();
                        System.out.println("Serialized Dog Objects");
                       
                        FileInputStream file_in = new FileInputStream("src\\net\\multivision\\serializable\\dogs.dat");
                        ObjectInputStream obj_in = new ObjectInputStream(file_in);
                        Object obj1 = obj_in.readObject();
                        Object obj2 = obj_in.readObject();
                        Object obj3 = obj_in.readObject();
                       
                        Dog new_dog1 = (Dog) obj1;
                        Dog new_dog2 = (Dog) obj2;
                        Dog new_dog3 = (Dog) obj3;
                       
                        System.out.println("Deserialized Dog Objects");
                        obj_in.close();
                        file_in.close();
                       
                        new_dog1.print();
                        new_dog2.print();
                        new_dog3.print();
                       
                }catch(FileNotFoundException e){
                        e.printStackTrace();
                }catch(IOException e){
                        e.printStackTrace();
                }catch(ClassNotFoundException e){
                        System.out.println("Couldn't find class");
                }
               
               
               
                /*Create a Dog class that implements serializable, and Dog HAS-A Collar that does NOT implement
                 * serializable. Assuming that you can't just make Collar serializable, create 3 dog objects. with
                 * collar objects, and serialize and deserialize these objects without throwing an exception.
                 * */
        }
 
}