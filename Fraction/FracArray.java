//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Monday, August 14th, 2017
//This class implements and manages a Fraction array
import java.util.Scanner;
public class FracArray{
    
    private int length, noFracc;
    private Fraction array[];
    
    //Parametrized constructor
    //Parameter length - how long will the Fraction array be
    //Creates a Fraction array of that length
    public FracArray(int length){
        this.noFracc = 0;
        this.length = length;
        array = new Fraction[this.length];
    }
    
    //Empty Constructor
    //Creates a Fraction array of length 1
    public FracArray(){
        this.noFracc = 0;       
        this.length = 1;
        array = new Fraction[this.length];
    }
    
    //Checks if the array is Empty
    //Returns boolean - "true" if is Empty, "false" if it is not
    public boolean isEmpty(){
        return noFracc == 0;
    }
    
    //Reads the Fractions and add them to the array
    //Parameter sc - scanner for reading the Fractions
    public void readFractions(Scanner sc){
        for(int i = 0; i < length; i++)
        {
            int num = sc.nextInt();
            int den = sc.nextInt();
            array[i] = new Fraction(num, den);
            noFracc++;
        }
    }
    
    //Makes the sum of all the Fractions
    //Returns Fraction - total sum
    public Fraction arrSum(){
        Fraction s = new Fraction();
        for(int i = 0; i < length; i++)
            s = s.sum(array[i]);
        return s;
    }
    
    //Average of all Fractions
    //Returns Fraction - average
    public Fraction avg(){
        Fraction a = this.arrSum();
        a = a.mul(new Fraction(1, length));
        return a;
    }
    
    //Merges sorted array's sections
    //Parameter arr - Fraction array
    //Parameter l - left index
    //Parameter m - middle index
    //Parameter r - right index
    public void merge(Fraction arr[], int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        Fraction L[] = new Fraction[n1];
        Fraction R[] = new Fraction[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l+i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m+1+j];
        int i = 0, j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(L[i].compareTo(R[j]) < 1)
                arr[k] = L[i++];
            else
                arr[k] = R[j++];
            k++;
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }
    
    //Sorts a Fraction Array using recursion
    //Parameter arr - Fraction array
    //Parameter l - left index
    //Parameter r - right index
    public void sort(Fraction arr[], int l, int r){
        if (l < r){
            int m = (l + r)/2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    
    //Prints the sorted Fraction array
    public void sortArray(){
        this.sort(this.array, 0, length - 1);
        int spaces = this.maxLength();
        for(int i = 0; i < length; i++){
            System.out.println(this.array[i].toString(spaces));
        }
    }
    
    //Gets the largest number of digits in a number of the Fraction array
    //Returns - largest number of digits
    public int maxLength(){
        int max = 0;
        for(int i = 0; i < length; i++){
            if(this.array[i].getNum() > max)
                max = this.array[i].getNum();
            if(this.array[i].getDen() > max)
                max = this.array[i].getDen();
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