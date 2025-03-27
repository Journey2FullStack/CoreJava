package functional.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerEx {
    public static void main(String[] args) {
//e: Perform an operation on a value without returning anything (e.g., logging, printing).
//How would you use Consumer to log each item in a list of strings using Stream?
        List<String> items = List.of("Ordered", "Invoiced", "In-Transit", "Collected", "Delivered");

//Signature: void accept(T t)
//Use Case: Perform an operation on a value without returning anything (e.g., logging, printing).
        Consumer<String> printLog = str -> System.out.println("Order Status, " + str);
        items.forEach(orderStatus -> printLog.accept(orderStatus));

//        2. Supplier<T>
//        Signature: T get()
//        Use Case: Returns a value without taking any input (e.g., random number, current timestamp, object factory)

        Supplier<String> defaultName = () -> "Guest";
        System.out.println(defaultName.get());  // Output: Guest

       /* How would you use Supplier to supply default values?*/

    }

}
