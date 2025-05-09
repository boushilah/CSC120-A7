/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building implements HouseRequirements {
  //Attributes 
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private int initialCapacity, maxcapacity;
/**
 * 
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param initialCapacity
 */

public House(String name, String address,int nFloors, boolean hasDiningRoom,int initialCapacity){
super(name,address,nFloors);
this.hasDiningRoom= hasDiningRoom;
this.initialCapacity= initialCapacity;
residents = new ArrayList<Student>(initialCapacity);
System.out.println("You have built a house: 🏠");  
}
public boolean hasDiningRoom(){
  if(this.hasDiningRoom){
  System.out.println(name+" has a dining room");
  return true;
  }
  else{
    System.out.println(name+" has no dining room");
    return false;
  }
}
/**
 * Chekcs the number of residents in the house. 
 * @return the size of the resident Arraylist
 */
  public int nResidents(){
    if (residents== null){
      System.out.println(name+ " has no residents");
      return 0;
    } else{
    return  residents.size();
  }
  }
/**
 * Adding new residents to the house.
 * checks whether the student is the house and if not add them to the residents arraylist.
 * @param s take the name of the student.
 * checks whether the student is the house and if not add them to the residents arraylist.
 */
  public void moveIn(Student s){
  if (!residents.contains(s)){
      residents.add(s);
  } else if (residents.size()>=maxcapacity){
   System.out.println("The house is full. Find another lodging");   
  } else{
    System.out.println("The student is already in the house!");
  }
  }

  /**
   * Checks to see if the student is a resident and moves students out of the house. 
   * @param s take the name of the resident
   * @return a student's name if they exist in the house, null if they do not. 
   */
  public Student moveOut(Student s){
    String name = s.getName();
    if(!residents.contains(s)){
      System.out.println("The student doesn't exist in this house");
      return null;
    } else{
      residents.remove(name);
      System.out.println("Resident "+name+" has been moved out");
      return s;
    }
  }
  /**
   * checks the existence of the student in the house.
   * @param s name of the student
   * @return whether the student exists in the ArrayList residents. 
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  }

 public static void main(String[] args) {
  House CampusHouse = new House("Cutter","10 Prospect Street",3,true,80);
  System.out.println(CampusHouse);
  Student  student1 = new Student("Fatima","9909abd",2025);
  Student student2= new Student("Yvon", "9909abe",2028);
  Student student3= new Student("Mzee","9909abf",2030);
  CampusHouse.moveOut(student1);
  CampusHouse.isResident(student1);
  CampusHouse.moveIn(student1);
  CampusHouse.moveIn(student2);
  CampusHouse.moveIn(student3);
  
  }

} 