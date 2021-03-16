package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public static void main(String args[]) {
        Truck truck = new Truck();
        System.out.println(truck.solution(2, 10, new int[]{7, 4, 5, 6}));

        System.out.println(truck.solution(100, 100, new int[]{10}));

        System.out.println(truck.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    class Car {
        int weight;
        int inTime;

        Car(int weight, int inTime){
            this.weight = weight;
            this.inTime = inTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = 0;

        Queue<Car> bridgeQueue = new LinkedList<>();
        ArrayList<Integer> truckWeightList = new ArrayList<>();

        for(int truckWeight : truck_weights){
            truckWeightList.add(truckWeight);
        }

        while (true) {
            if(bridgeQueue.size() == 0 && truckWeightList.size() == 0) break;

            time++;

            if( bridgeQueue.size() > 0 && time - bridgeQueue.peek().inTime >= bridge_length ) {
                currentWeight = currentWeight - bridgeQueue.poll().weight;
            }

            if(truckWeightList.size() > 0 && currentWeight + truckWeightList.get(0) <= weight) {
                currentWeight = currentWeight + truckWeightList.get(0);
                bridgeQueue.offer(new Car(truckWeightList.get(0), time));
                truckWeightList.remove(0);
            }
        }

        return time;
    }
}