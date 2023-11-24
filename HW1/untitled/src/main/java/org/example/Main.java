package org.example;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



/**
 * Напишите программу, которая использует Stream API для обработки списка чисел. Программа должна вывести на экран
 * среднее значение всех четных чисел в списке.
 */

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = IntStream.range(0,100).map(x ->{
            if (x < 0){
                x = x * -1;
            }else rand.nextInt();
            return x;
        }).toArray();
        Collection<Integer> list =Arrays.stream(numbers).boxed().collect(Collectors.toList());
        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(stats.getAverage());
    }


}