// FunctionUtil.java
package com.jdojo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtil {
    // Applies an action on each item in a list
    public static <T> void forEach(List<T> list, Consumer<? super T> action) {
        for (T item : list) {
            action.accept(item);
        }
    }

    // Applies a filter to a list and returns the filtered list items
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }
        
        return filteredList;
    }

    // Maps each item in a list to a value
    public static <T, R> List<R> map(List<T> list, Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T item : list) {
            mappedList.add(mapper.apply(item));

        }
        
        return mappedList;
    }
}
