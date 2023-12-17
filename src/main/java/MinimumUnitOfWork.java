import java.util.*;

public class MinimumUnitOfWork {

    public static void main(String args[]) {


        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};



        int[] allNs = {2, 1, 0, 3, 3};


        int minimumUnits = minimumUnitOfWork(allTasks[0],allNs[0]);
        System.out.println(minimumUnits);
    }

    private static int minimumUnitOfWork(char characters[], int n) {


        //First put all characters based on their occurence in  a Map
        //With char as Key and the Maximum Number of times it comes as its Values
        //Example:

        // A : 2 , B:2

        Map<Character,Integer> sequenceMap = new HashMap<>();
        for(char ch : characters) {

           sequenceMap.put(ch,sequenceMap.getOrDefault(ch,0) + 1);


        }




        //Exhibit B

        /**
         *
         * In other words, if we have more than one task having the maximum frequency, the equation above doesn’t hold.
         * Therefore, we consider the maximum frequency at every step, and the formula is modified as:
         *
         * Idle time=Idle time−min(Max frequency−1, Current frequency)
         *
         * For example, tasks =
         *
         * [A,A,B,B]
         *  and n =
         * 2
         *
         *  After scheduling task
         *
         * A as A _ _ A
         *  , the remaining idle slots become
         * 2
         *  Now, if we schedule task B as A B B A
         * , we break the cooling period rule. Therefore, we need to schedule it as   A B _ A B
         *
         *  Using the equation above, the idle time comes out to be
         * 1
         * because
         *  Idle time=2−min(2−1, 2)=1
         *
         *
         *
         *
         *
         *
         */

        //Next Sort this Map based on the Maximum occurences as Last
        // There is No easy way to sort this we have to use List

        List<Map.Entry<Character,Integer>> sortedFrequences  = new ArrayList<>(sequenceMap.entrySet());

        Collections.sort(sortedFrequences,(lhs,rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        int maxFrequency = sortedFrequences.get(sortedFrequences.size()-1).getValue();
        sortedFrequences.remove(sortedFrequences.size()-1);
        int idleTime = (maxFrequency- 1) * n; // WHY ? Because we need the idleTime at each iteration

        while(!sortedFrequences.isEmpty() && idleTime > 0) {

            int currentFrequency = sortedFrequences.get(sortedFrequences.size()-1).getValue();
            idleTime = idleTime - Math.min(maxFrequency-1,currentFrequency); //Important Step because there might be a scenario
            //See comments above Exhibit b
            sortedFrequences.remove(sortedFrequences.size() - 1);

        }

        idleTime = Math.max(0,idleTime);

        return characters.length + idleTime;

    }


}
