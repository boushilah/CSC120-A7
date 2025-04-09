import java.util.Hashtable;
public class Library extends Building{

private Hashtable<String, Boolean> collection;

/**
 * Constructor
 * @param name takes the name of the library
 * @param address shows the address at which the libray is located
 * @param nFloors is the number of floors of the library.
 */
public Library(String name, String address, int nFloors) {
  super(name, address, nFloors);
  collection = new Hashtable<String, Boolean>();
  System.out.println("You have built a library: 📖");
}

/**
 * method for add the title to the collection.
 * @param title name of the book to be added
 */
public void addTitle(String title){
  collection.put(title,true);
  System.out.println("-"+title+"- has been added to the collection");
}
/**
 * method removes the book from the collection
 * @param title name of the book to be removed.
 */
public String removeTitle(String title){
  if(collection.containsKey(title)){
    collection.remove(title);
    System.out.println("This book has been removed");
    return title;
  }
  else{
    System.out.println("This requested title is not found");
    return null;
  }
}
/**
 * Checks out a book from the collection
 * @param title the title of the book to tbe checked out. 
 */
public void checkOut(String title){
if(collection.containsKey(title)&& (collection.get(title)==true)){
collection.put(title,false);
}
else{
  System.out.println("This book is not available");
}
}
/**
 * Returning the book to the collection
 * @param title the name of the book to be returned to the collection.
 */
public void returnBook(String title){
  if(collection.containsKey(title)){
    if(collection.get(title)==false){
      collection.put(title,true);
    }
    else{
      System.out.println(title+" is already returned");
    }
  }
} 
/**
 * Checks to see if the collection contains the title of the book.
 * @param title is the name of the book to be checked. 
 * returns true if the title appears as a key in the Libary's collection, false otherwise
 */
public boolean containsTitle(String title){
if(collection.containsKey(title)){
  return true;
}
else{
  return false;
}
}
/**
 * Checks if the 
 * returns true if the title is currently available, false otherwise
 */
public boolean isAvailable(String title){
  if(collection.containsKey(title)){
    if((collection.get(title)==true)){
      System.out.println(title+" is available");
      return true;
    }
    else{
    System.out.println(title+" is not available");
    return false;
    }}
    else{
    System.out.println("Unfortunately, we do not have -"+ title+"- book in our collection");
    return false;
    }
      
}
/**
 *  prints out the entire collection in an easy-to-read way (including checkout status)
 */
public void printCollection(){
System.out.println("Please check out our collection below:");
System.out.println(collection);
}  
@Override
public String toString(){
  return super.toString()+" with "+collection.size()+" books.";
}

public static void main(String[] args) {
 Library Neilson = new Library("Neilson", "7 Neilson Drive", 4);
 System.out.println(Neilson);
Neilson.addTitle("Language studies by Andy Kabagena");
Neilson.isAvailable("Ururimi by Bwiza");
}
}