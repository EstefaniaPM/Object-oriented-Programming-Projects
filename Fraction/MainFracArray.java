//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Monday, August 14th, 2017
//This class is the main program for the execution
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		FracArray arr = new FracArray();
		int option = -1;
		
		while(option != 0){
			System.out.println("1. Read Fractions");
			System.out.println("2. Get the sum of all the fractions");
			System.out.println("3. Get the average");
			System.out.println("4. Show the sorted Fractions");
			System.out.println("0. Exit");
			option = sc.nextInt();
			switch(option){
				case 1:
				System.out.println("How many fractions will be introduced?");
				int n = sc.nextInt();
				arr = new FracArray(n);
				System.out.println("Insert them:");
				arr.readFractions(sc);
				break;
				case 2:
				if(!arr.isEmpty())
					System.out.println("The sum of the fractions is "+arr.arrSum());
				else
					System.out.println("You first must introduce the fractions");
				break;
				case 3:
				if(!arr.isEmpty())
					System.out.println("The average of the fractions is "+arr.avg());
				else
					System.out.println("You first must introduce the fractions");
				break;
				case 4:
				if(!arr.isEmpty()){
					System.out.println("The sorted fractions are:");
					arr.sortArray();
				}
				else
					System.out.println("You first must introduce the fractions");
				break;
			}
		}
	}
}