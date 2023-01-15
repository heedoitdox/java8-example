package e08_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
        System.out.println("collection(toSet()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );

        // joining
        System.out.println("collection(joining(\", \")): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", ", "[", "]")) // [#6, #6, #10, #10]
        );

        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1,2,3,4,5, 127)
                        .filter(i -> i == integer127)
                        .findFirst()
        );

        // 캐싱되지않은 integer
        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1,2,3,4,5, 128)
                        .filter(i -> i.equals(integer128))
                        .findFirst()
        );

        final Integer integer3 = 3;
        System.out.println(".filter(i -> i > integer3).count(): " +
                Stream.of(1,2,3,4,5)
                        .filter(i -> i > integer3)
                        .count()
        );
    }
}
