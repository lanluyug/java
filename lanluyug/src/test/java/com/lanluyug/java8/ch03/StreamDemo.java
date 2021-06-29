package com.lanluyug.java8.ch03;

import org.junit.Test;

import javax.sound.midi.Track;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    public void testStream(){
        List<String> artists = Stream.of("a","b","c").collect(Collectors.toList());
        List<String> artists1 = Stream.of("a","b","c").collect(Collectors.toList());


        long count = artists.stream().filter( artist -> artist.length() > 5).count();

        //map
        List<String> strings = Stream.of("a","b").map(str-> str.toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        System.out.println(strings);
        // filter
        List<String> artistsFilter =artists.stream().filter( artist -> artist.length() > 5).collect(Collectors.toList());

        // flatMap合并多个list
//        List<String> combined1 = Stream.of(artists,artists1).flatMap(numbers-> numbers.stream()).collect(Collectors.toList());
        List<String> combined = Stream.of(artists,artists1).flatMap(Collection::stream).collect(Collectors.toList());

        // max min
        String min = Stream.of("12","1111").min(Comparator.comparing(String::length)).get();


        // reduce
        int count1 = Stream.of(1,2,3).reduce(0, Integer::sum);
        assert count1==6;
    }
}
