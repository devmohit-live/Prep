// # Log based Python program to count number of 

// JAVA Code to count number of 
// digits in an integer 
import java.util.*;

public class Number_of_digits {

    static int countDigit(long n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        long n = 345289467;
        System.out.print("Number of digits : " + countDigit(n));
    }
}
// This code is contributed by Arnav Kr. Mandal.
