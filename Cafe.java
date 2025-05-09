import java.util.Scanner;
public class Cafe extends Building implements CafeRequirements{
//Attributes
private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
private int nSugarPackets; // The number of sugar packets remaining in inventory
private int nCreams; // The number of "splashes" of cream remaining in inventory
private int nCups; // The number of cups remaining in inventory
public Cafe(String name, String address,int nFloors, int nCoffeeounces, int sugarPackets, int ncreams,int cups) {
 super(name,address,nFloors);
 this.nCoffeeOunces= nCoffeeounces;
 this.nSugarPackets= sugarPackets;
 this.nCreams = ncreams;
 this.nCups= cups;
System.out.println("You have built a cafe: ☕");
 }
 /**
  * Sells coffee
  * @param size the size of the coffee
  * @param nSugarPackets the number of sugar packs put into the coffee
  * @param nCreams the amount of cream that goes into the cafe. 
  */
public void sellCoffee(int size, int nSugarPackets, int nCreams) {
    if ((nCoffeeOunces >= size) && (this.nSugarPackets >= nSugarPackets) &&(this.nCreams >= nCreams) && (nCups > 0)) {
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups--;
        System.out.println("Coffee's ready!");
    } else {
        System.out.println("We don't have the required stock!");
        System.out.print("Would you like to restock? (yes/no): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            restock(20, 50, 50, 50);
        }
    }
}

/**
 * Restocks the ingredients 
 * @param nCoffeeOunces is the amount of coffe 
 * @param nSugarPackets is the sugar packets number
 * @param nCreams number of creams to be added
 * @param nCups is the number of cups we have .
 */
private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
    this.nCoffeeOunces+=nCoffeeOunces;
    this.nSugarPackets+=nSugarPackets;
    this.nCreams+=nCreams;
    this.nCups += nCups;
    System.out.println("The updated stock is:");
    System.out.println("Coffee ounces: "+nCoffeeOunces+", Sugar Packets: "+nSugarPackets+", Packets of Creams: "+nCreams+", Cups: "+nCups);
}
    public static void main(String[] args) {
       Cafe Columbiano = new Cafe("Nkurunziza","32 Nyarutarama", 1,30,50,100,100);
    System.out.println(Columbiano);
    Columbiano.restock(4,20,12,5);
    Columbiano.sellCoffee(3, 2, 4);
    }
    
}
