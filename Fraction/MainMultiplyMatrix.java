//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Monday, August 21st, 2017
//This class is the main program for the execution
import java.util.Scanner;
public class MainMultiplyMatrix{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of rows in the first matrix:");
        int rows = sc.nextInt();
        System.out.print("Number of columns in the first matrix:");
        int columns = sc.nextInt();
        System.out.print("Number of rows in the second matrix:");
        int rows2 = sc.nextInt();
        System.out.print("Number of columns in the second matrix:");
        int columns2 = sc.nextInt();
        
        if(columns == rows2){
            FractionMatrix m1 = new FractionMatrix(rows, columns), m2 = new FractionMatrix(rows2, columns2);
            System.out.println("Insert the fractions for the first matrix:");
            m1.readMatrix(sc);
            System.out.println("Insert the fractions for the second matrix:");
            m2.readMatrix(sc);
            System.out.println();
            m1.printMatrix();
            System.out.println();
            System.out.println("X");
            System.out.println();
            m2.printMatrix();
            System.out.println();
            System.out.println("=");
            System.out.println();
            FractionMatrix newMatrix = m1.multiply(m2);
            newMatrix.printMatrix();
        }
        else
            System.out.println("The operation is impossible");
    }
}