package functional.lambda;

public class FunctionalLamdaEx {
    public static void main(String[] args) {
        Calculator c = (a,b) -> a + b;
        System.out.println("sum is "+ c.calculate(3,4));
        c = (a,b) -> a - b;
        System.out.println("Substraction is "+ c.calculate(3,4));
        c = (a,b) -> a * b;
        System.out.println("Multiplication is "+ c.calculate(3,4));
        c = (a,b) -> a / b;
        System.out.println("Division is "+ c.calculate(3,4));
    }
}
