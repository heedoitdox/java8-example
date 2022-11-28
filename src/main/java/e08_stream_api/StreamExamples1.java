package e08_stream_api;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples1 {
    public static void main(String[] args) {
        // 범위를 지정하여 무한대 리스트 만들기
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(i + " "));

        // 진짜 무한대가 아님 - Int 는 최대값이 정해져 있기 때문
        IntStream.iterate(1, i -> i + 1).forEach(i -> System.out.println(i + " "));

        // 진짜 무한대는..?
        Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                .forEach(i -> System.out.println(i + " "));
    }
}
