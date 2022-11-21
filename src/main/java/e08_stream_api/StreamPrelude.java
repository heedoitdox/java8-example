package e08_stream_api;

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
    }
}
