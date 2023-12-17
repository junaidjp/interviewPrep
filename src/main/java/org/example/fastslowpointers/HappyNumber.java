package org.example.fastslowpointers;

public class HappyNumber {




    public static void main(String args[]) {

        int sumofSquarednumbers = sumofSquaredNumbers(19);
        System.out.println(sumofSquarednumbers);

    }

    private static int sumofSquaredNumbers(int number) {
   //Example number 19
        int totalSum =0;

        while(number > 0) {


            int digit = number % 10;
           //First iteration
            //digit = 19 % 10  = 9 (last digit)
            //number = 19/10 = 1 (remaining digit)
            //Total Sum = 9^2 = 81
            //Second iteration
            //digit = 1 % 10  = 1 (last digit)
            //number = 1/10 = 0 (remaining digit)
            //Total Sum = 81   + 1^2 = 82
            //Second iteration
            number = number /10;
            totalSum+= (Math.pow(digit,2));


        }
        return totalSum;
    }
}
