package programmers;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Printer printer = new Printer();

        System.out.println(printer.solution(new int[]{2,1,3,2}, 2));
        System.out.println(printer.solution(new int[]{1,1,9,1,1,1}, 0));
    }

    class Print {
        int priotiry;
        int location;

        Print(int priotiry, int location) {
            this.priotiry = priotiry;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Print> printQueue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            printQueue.offer(new Print(priorities[i], i));
        }

        int order = 0;
        while ( true ) {
            Boolean existsPriority = false;

            Iterator iterator = printQueue.iterator();
            while(iterator.hasNext()){
                Print print = (Print) iterator.next();
                if(printQueue.peek().priotiry < print.priotiry) {
                    existsPriority = true;
                    break;
                }
            }

            if(existsPriority) {
                printQueue.offer(printQueue.poll());
                continue;
            }

            Print exitPrint = printQueue.poll();
            order++;

            if(exitPrint.location == location) {
                break;
            }
        }

        return order;
    }
}
