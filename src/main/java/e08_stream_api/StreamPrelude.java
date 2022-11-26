package e08_stream_api;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
    public static void main(String[] args) {

        /*
          입력값이 다른데 결과값이 같은 함수
          Math.abs()
         */
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);
        System.out.println("abs1 == abs2 is " + (abs1 == abs2));

        final int maxInt = Math.abs(Integer.MAX_VALUE);
        final int minInt = Math.abs(Integer.MIN_VALUE);
        System.out.println("maxInt: " + maxInt);
        System.out.println("minInt: " + minInt);


        /**
         * 08 Stream API - 02 Identity Function
         */
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("mapOld(numbers, i -> i * 2)\n" +
                mapOld(numbers, i -> i * 2));
        System.out.println("mapOld(numbers, null)\n" +
                mapOld(numbers, null));

        System.out.println();
        System.out.println(map(numbers, i -> i * 2));

        // 아래 두개는 결과가 같다.
        System.out.println(map(numbers, i -> i));
        System.out.println(map(numbers, Function.identity()));
    }

    // identity Function 을 사용함
    private static <T,R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t: list) {
            result.add(mapper.apply(t));
        }
        return result;
    }

    // 리스트에 들어있는 타입을 다른 타입으로 변환시켜준다.
    // imperative programming (명령식 프로그래밍) - old 함
    private static <T,R> List<R> mapOld(final List<T> list, final Function<T, R> mapper) {
        final List<R> result;

        if (mapper != null) {
            result = new ArrayList<>();
        } else {
            // 캐스팅을 해주어야 함
            result = new ArrayList<>((List<R>) list);
        }

        if (result.isEmpty()) {
            for (final T t: list) {
                result.add(mapper.apply(t));
            }
        }

        return result;
    }
}
