package com.sparta.java.sorter;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsSorter implements Sorter {

    @Override
    public String getType() {
        return "Collections Sort";
    }

    @Override
    public int[] sort(int[] a) {
        List<Integer> arrList = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(arrList);
        return arrList.stream().mapToInt(i->i).toArray();
    }

}
