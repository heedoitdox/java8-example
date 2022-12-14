package e08_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamExamples3 {
    public static void main(String[] args) {
        System.out.println("collection(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toList())
        );

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        final Stream<Integer> integerStream = Stream.of(1,2,3,4,5);

        // set 으로 받기
        System.out.println("collection(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );
    }
}
