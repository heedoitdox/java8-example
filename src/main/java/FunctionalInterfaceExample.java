import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        /**
         * Function
         */
        final Function<String, Integer> toInt = s -> Integer.parseInt(s);

        final Integer number = toInt.apply("100");
        System.out.println(number);

        // Function 에 있는 identity 를 그대로 사용
        final Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(999));

        // 직접 만들고 싶다면
        final Function<Integer, Integer> identity2 = t -> t;
        System.out.println(identity2.apply(998));

        /**
         * Consumer
         */
        final Consumer<String> print = value -> System.out.println(value);
        final Consumer<String> greetings = value -> System.out.println("hello " + value);

        print.accept("hello");
        greetings.accept("World");
    }
}
