// FlatMappingTest.java
package com.jdojo.streams;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.entry;
import java.util.Set;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class FlatMappingTest {
    public static void main(String[] args) {
        // Represent the gender and the list of spoken languages
        List<Entry<String, Set<String>>> list = List.of(
                entry("Male", Set.of("English", "French")),
                entry("Male", Set.of("Spanish", "Wu")),
                entry("Female", Set.of("English", "French")),
                entry("Male", Set.of("Wu", "Lao")),
                entry("Female", Set.of("English", "German")),
                entry("Male", Set.of("English")));

        Map<String, Set<String>> langByGender = list.stream()
                .collect(groupingBy(Entry::getKey,
                        flatMapping(e -> e.getValue().stream(), toSet())));

        System.out.println(langByGender);
    }
}
