import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void runFunctional(String[] args) {
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

        /**
         * Predicate
         */
        Predicate<Integer> isPositive = i -> i > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        ArrayList<Object> positiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if(isPositive.test(num)) positiveNumbers.add(num);
        }
        System.out.println("positive integers: " + positiveNumbers);

        Predicate<Integer> lessThan3 = i -> i < 3;
        ArrayList<Object> numbersLessThan3 = new ArrayList<>();
        for (Integer num : numbers) {
            if(lessThan3.test(num)) numbersLessThan3.add(num);
        }
        System.out.println("less than 3 integers: " + numbersLessThan3);

        System.out.println("filter positive integers : " + filter(numbers, i -> i > 0));
        System.out.println("filter less than 3 integers : " + filter(numbers, lessThan3));

        /**
         * Supplier
         */
        final Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "world");

        long start = System.currentTimeMillis();
        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> getVeryExpensiveValue());

        System.out.println("It took " + (System.currentTimeMillis() - start) / 1000 + " seconds.");
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Let's just say it has very expensive calculation here!
        return "Heedoitdox";
    }

//    private static void printIfValidIndex(int number, String value) {
    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if(number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        }else {
            System.out.println("Invalid");
        }
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for(T input : list) {
            if(filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        println(1L, "heedoitdox", "heedoitdox@gmail.com",
                (id, name, email) -> "User info: ID = " + id + ", name = " + name + " , email = " + email );
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function){
        System.out.println(function.apply(t1, t2, t3));
    }
}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}
