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
        int[] numbers = IntStream.range(0,10).map(x ->{
            x = rand.nextInt();
            if (x < 0){
                x = x * -1;
            }
            return Math.round(x/1000000);
        }).filter(x -> x % 2 == 0).toArray();
        Collection<Integer> list =Arrays.stream(numbers).boxed().collect(Collectors.toList());
        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Среднее арифметическое из:\n" + list + "\n" + "равно - " + stats.getAverage());
    }


}