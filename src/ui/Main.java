package ui;
import model.*;
import java.util.Scanner;
/**
 * @author David_Malte "RanitaUwU, RagnarArik"
*/
public class Main{
    public static Vivero vivero = new Vivero("Sunny Nursery", "216 Newbury Street");
	public static Scanner sc=new Scanner(System.in);
	public static void main (String[]args){
        int plantCont=0;
        for(boolean exit=false;exit!=true;){
        	System.out.println("NURSERY");
	        System.out.println("1. Add new plant");
	        System.out.println("2. Ornamental plants that measure more than one meter");
	        System.out.println("3. Date of the next flowering of a plant.");
	        int sel=sc.nextInt();
	        sc.nextLine();
	        switch(sel){
	            case 1: addPlant(sc,plantCont);
	                    plantCont++;
	                break;
	            case 2: showOrnamental();
	                break;
	            case 3: nextFlowering(sc);
	                break;
	        }
        }
        sc.close();
    }

    public static void addPlant(Scanner sc, int plantCont){
        System.out.println("There are "+plantCont+" planted");
        System.out.println("Select the kind of plant: \n 1. frutal \n 2. ornamental \n");
        int plantType=sc.nextInt();
        sc.nextLine();
        if(plantType==1)
            frutal(sc);
        else if(plantType==2)
            ornamental(sc);

    }

    public static void frutal(Scanner sc){
        System.out.println("Enter the name of the plant");
        String name=sc.nextLine();
        System.out.println("Enter the cost of the plant");
        double cost=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the name of the fruit");
        String nameFruit=sc.nextLine();
        String message=vivero.addPlantFrutal(name,cost,nameFruit);
        System.out.println(message);
    }
    
    private static void ornamental(Scanner sc) {
        System.out.println("Enter the name of the plant");
        String name=sc.nextLine();
        System.out.println("Enter the cost of the plant");
        int cost=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the maximum height in mts");
        int height=sc.nextInt();
        sc.nextLine();
        String message=vivero.addPlantOrnamental(name,cost,height);
        System.out.println(message);
    }
    
    public static void showOrnamental(){
    	String message=vivero.showOrnamental();
    	System.out.println(message);
    }

    public static void nextFlowering(Scanner sc){
    	System.out.println("Enter the name of the plant to search");
    	String search=sc.nextLine();
        System.out.println("Enter the month sowing");
        int monthSowing=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the year sowing");
        int yearSowing=sc.nextInt();
        sc.nextLine();
        String message=vivero.nextFlowering(search,monthSowing,yearSowing);
        System.out.println(message);
    }
}