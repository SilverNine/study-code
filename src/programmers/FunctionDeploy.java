package programmers;

import java.util.*;

public class FunctionDeploy {
    public static void main(String[] args) {
        FunctionDeploy functionDeploy = new FunctionDeploy();

        for(int value : functionDeploy.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})) {
            System.out.println(value);
        }

        for(int value : functionDeploy.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})) {
            System.out.println(value);
        }
    }

    class Function {
        int currentProgress = 0;
        int speed = 0;

        Function (int currentProgress, int speed) {
            this.currentProgress = currentProgress;
            this.speed = speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        Queue<Function> functionQueue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            Function function = new Function(progresses[i], speeds[i]);
            functionQueue.offer(function);
        }

        while ( true ) {
            if(functionQueue.size() == 0) break;

            int deployFunctionCount = 0;

            Iterator iterator = functionQueue.iterator();
            while(iterator.hasNext()){
                Function function = (Function) iterator.next();
                function.currentProgress = function.currentProgress + function.speed;

                if(functionQueue.peek().currentProgress >= 100){
                    iterator.remove();
                    deployFunctionCount++;
                }
            }

            if(deployFunctionCount > 0) {
                answerList.add(deployFunctionCount);
            }
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
