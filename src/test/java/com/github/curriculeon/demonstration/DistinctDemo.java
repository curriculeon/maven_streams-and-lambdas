package com.github.curriculeon.demonstration;

import com.github.curriculeon.tools.RandomUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by leon on 8/4/2020.
 */
public class DistinctDemo {
    @Test
    public void test() {
        String[] names = "john jim george fox jumps over the lazy dog".split(" ");
        System.out.println(Arrays
                .asList(names)
                .stream()
                .distinct()
                .collect(Collectors.toList()));
    }
}
