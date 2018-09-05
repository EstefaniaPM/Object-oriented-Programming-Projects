//Estefania Pitol Martinez A01551688
//Fernanda Montano Rios    A01730440

//Wednesday, September 13th, 2017
//This program reads n fractions and sorts them with different methods, then compares their run times

import java.util.Scanner;
import java.io.*;
import java.util.concurrent.*; 

public class Main{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Fraction insertionArray[] = new Fraction[n];
        Fraction selectionArray[] = new Fraction[n];
        Fraction bubbleArray[] = new Fraction[n];
        Fraction mergeArray[] = new Fraction[n];
        Fraction quickArray[] = new Fraction[n];

        for(int i = 0; i < n; i++){
            int num = sc.nextInt(), den = sc.nextInt();
            insertionArray[i] = new Fraction(num, den);
            selectionArray[i] = new Fraction(num, den);
            bubbleArray[i] = new Fraction(num, den);
            mergeArray[i] = new Fraction(num, den);
            quickArray[i] = new Fraction(num, den);
        }

        long runTimes[] = new long[5];
        long start, end;

        String runTimesNames[] = {"Insertion sort:", "Selection sort:", "Bubble sort:   ", "Merge sort:    ", "Quick sort:    "};

        System.out.println("Insertion sort:");
        start = System.nanoTime();
        insertionSort(insertionArray);
        end = System.nanoTime();
        runTimes[0] = end - start;
        printArrayFormat(insertionArray);
        System.out.println();

        System.out.println("Selection sort:");
        start = System.nanoTime();
        selectionSort(selectionArray);
        end = System.nanoTime();
        runTimes[1] = end - start;
        printArrayFormat(selectionArray);
        System.out.println();

        System.out.println("Bubble sort:");
        start = System.nanoTime();
        bubbleSort(bubbleArray);
        end = System.nanoTime();
        runTimes[2] = end - start;
        printArrayFormat(bubbleArray);
        System.out.println();

        System.out.println("Merge sort:");
        start = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        end = System.nanoTime();
        runTimes[3] = end - start;
        printArrayFormat(mergeArray);
        System.out.println();

        System.out.println("Quick sort:");
        start = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        end = System.nanoTime();
        runTimes[4] = end - start;
        printArrayFormat(quickArray);
        System.out.println();

        System.out.println("Run times:");
        System.out.println();
        printRunTimes(runTimes, runTimesNames);
    }

    //Sorts and prints the run times
    //Parameter runs - run times array
    //Parameter names - names of the run times
    public static void printRunTimes(long runs[], String names[]){

        for(int i = 1; i < runs.length; i++){
            long aux = runs[i];
            String aux2 = names[i];
            int j = i;
            while(j != 0 && aux < runs[j - 1]){
                runs[j] = runs[j - 1];
                names[j] = names[j -1];
                j--;
            }
            runs[j] = aux;
            names[j] = aux2;
        }

        for(int i = 0; i < 5; i++)
            System.out.println(names[i] + " " + runs[i] + " nanoseconds");
    }

    //Sorts the array using insertion method
    //Parameter arr - Fraction array
    public static void insertionSort(Fraction arr[]){

        for(int i = 1; i < arr.length; i++){
            Fraction aux = arr[i];
            int j = i;
            while(j != 0 && aux.compareTo(arr[j - 1]) < 0){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = aux;
        }
    }

    //Sorts the array using selection method
    //Parameter arr - Fraction array
    public static void selectionSort(Fraction arr[]){

        for(int i = 0; i < arr.length; i++){
            int minor = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[minor]) < 0)
                    minor = j;
            }
            Fraction aux = arr[i];
            arr[i] = arr[minor];
            arr[minor] = aux;
        }
    }

    //Sorts the array using bubble method
    //Parameter arr - Fraction array
    public static void bubbleSort(Fraction arr[]){

        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i = 1; i < arr.length; i++){
                if(arr[i].compareTo(arr[i-1]) < 0){
                    Fraction aux = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = aux;
                    isSorted = false;
                }
            }
        }
    }

    //Merges sorted array's sections
    //Parameter arr - Fraction array
    //Parameter l - left index
    //Parameter m - middle index
    //Parameter r - right index
    public static void merge(Fraction arr[], int l, int m, int r){

        int n1 = m - l + 1;
        int n2 = r - m;
        Fraction L[] = new Fraction[n1];
        Fraction R[] = new Fraction[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
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
    
    //Sorts the array using merge method
    //Parameter arr - Fraction array
    //Parameter l - left index
    //Parameter r - right index
    public static void mergeSort(Fraction arr[], int l, int r){

        if (l < r){
            int m = (l + r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    
    //Sorts the array using the pivote
    //Parameter arr - Fraction array
    //Parameter low - index of the loewst element
    //Parameter high - index of the highest element
    //Returns position of the pivote in the right place
    public static int partition(Fraction arr[], int low, int high){

        Fraction pivot = arr[high]; 
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if (arr[j].compareTo(pivot) <= 0){
                i++;
                Fraction temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Fraction temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    //Sorts the array using quick method
    //Parameter arr - Fraction array
    //Parameter low - Starting index
    //Parameter high - Ending index
    public static void quickSort(Fraction arr[], int low, int high){

        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    //Prints array with format
    //Parameter arr - Fraction Array
    public static void printArrayFormat(Fraction arr[]){

        int maxLengthArray = maxLength(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i].toString(maxLengthArray));
    }

    //Gets the largest number of digits in a number of the Fraction array
    //Parameter arr - Fraction Array
    //Returns - largest number of digits
    public static int maxLength(Fraction arr[]){

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].getNum() > max)
                max = arr[i].getNum();
            if(arr[i].getDen() > max)
                max = arr[i].getDen();
        }
        return countDigits(max);
    }
    
    //Counts the digits of a number
    //Parameter n - number
    //Returns - number of digits
    public static int countDigits(int n){

        int counter = 1;
        while(n/10 != 0){
            n /= 10;
            counter++;
        }
        return counter;
    }
}