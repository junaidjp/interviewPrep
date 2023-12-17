package org.example.slidingwindows;

public class BestTimetoBuySellStock {

    public static void main(String args[]) {


        int[] stockprices = {7,1,5,3,6,4,};
        //int profit = 5;
        int maxProfit = maxProfit(stockprices);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] stockprices) {



        int buy = 0;
        int sell =1;
        int maxProfit = 0;

        for(sell=1; sell < stockprices.length;sell++) {


            if(stockprices[sell] > stockprices[buy]) {
                maxProfit = Math.max(maxProfit,stockprices[sell] - stockprices[buy]);


            }else {
                buy = sell;
            }


        }
    return maxProfit;

    }
}
