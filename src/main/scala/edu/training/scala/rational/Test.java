package edu.training.scala.rational;


import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        int res = Stream.of(1,2,3,4,5,6).reduce(0,(prev, current) -> 10 * prev + current);
        System.out.println(res);
        int num = 123456;
        Stream.generate(() -> num % 10 ).limit(4).forEach(System.out::println);
    }
}
