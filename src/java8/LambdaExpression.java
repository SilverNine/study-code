package java8;

public class LambdaExpression {
    public static void main(String args[]) {
        LambdaExpression lambdaExpression = new LambdaExpression();
        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            System.out.println("a : " + a);
            System.out.println("b : " + b);
            return a * b;
        };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambdaExpression.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambdaExpression.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + lambdaExpression.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambdaExpression.operate(10, 5, division));

        //with parenthesis
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService1.sayMessage("Eungoo");
        greetingService2.sayMessage("SilverNine");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
