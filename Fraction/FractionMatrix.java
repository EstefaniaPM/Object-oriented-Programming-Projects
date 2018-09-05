//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Monday, August 21st, 2017
//This class is for creating a Fraction matrix and manage it
import java.util.Scanner;
public class FractionMatrix{

    private int columns, rows;
    private Fraction matrix[][];

    //Parametrized constructor
    //Parameter rows - number of rows in the matrix
	//Parameter columns - number of columns in the matrix
    //Creates a Fraction matrix
    public FractionMatrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        matrix = new Fraction[rows][columns];
    }

    //Empty constructor
    //Creates a Fraction matrix of [1][1]
    public FractionMatrix(){
        this.rows = 1;
        this.columns = 1;
        matrix = new Fraction[rows][columns];
    }

    //Reads the Fractions and add them to the matrix
    //Parameter sc - scanner for reading the Fractions
    public void readMatrix(Scanner sc){
        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.columns; j++){
                int num = sc.nextInt();
                int den = sc.nextInt();
                matrix[i][j] = new Fraction(num, den);
            }
    }

    //Multiply the actual Fraction matrix and other Fraction matrix
    //Parameter other - the other Fraction
	//Returns Fraction - multiplication result
    public FractionMatrix multiply(FractionMatrix m){
        FractionMatrix newMatrix = new FractionMatrix(this.rows, m.columns); 
        Fraction totalSum = new Fraction();
        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < m.columns; j++){
                for(int k = 0; k < this.columns; k++)
                    totalSum = totalSum.sum(matrix[i][k].mul(m.matrix[k][j]));
                newMatrix.matrix[i][j] = totalSum;
                totalSum = new Fraction();
            }
        return newMatrix;
    }

    //Prints the matrix
    public void printMatrix(){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++)
                System.out.print(this.matrix[i][j].toString(this.maxLength())+"    ");
            System.out.println();
        }
    }

    //Gets the largest number of digits in a number of the Fraction matrix
    //Returns - largest number of digits
    public int maxLength(){
        int max = 0;
        for(int i = 0; i < this.rows; i++)
            for(int j = 0; j < this.columns; j++){
                if(this.matrix[i][j].getNum() > max)
                    max = this.matrix[i][j].getNum();
                if(this.matrix[i][j].getDen() > max)
                    max = this.matrix[i][j].getDen();
            }
        return countDigits(max);
    }
    
    //Counts the digits of a number
    //Parameter n - number
    //Returns - number of digits
    public int countDigits(int n){
        int counter = 1;
        while(n/10 != 0){
            n /= 10;
            counter++;
        }
        return counter;
    }
}