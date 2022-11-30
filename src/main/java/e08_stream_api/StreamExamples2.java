package e08_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples2 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5)
                .forEach(i -> System.out.println(i + " "));

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer result = null;
        for (final Integer number: numbers) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("Imperative Result: " + result);

        System.out.println("Functional Result : " +
                numbers.stream()
                        .filter(number -> number > 3 && number < 9)
                        .map(number -> number * 2)
                        .filter(number -> number > 10)
                        .findFirst()
        );
    }
}
