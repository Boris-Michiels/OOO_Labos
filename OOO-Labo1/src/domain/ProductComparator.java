package domain;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductComparator implements Comparator<Product> {
    private final Map<String, Integer> sort = Stream.of(new Object[][] {
            { "Movie", 1 },
            { "Game", 2 },
            { "CD", 3 },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    @Override
    public int compare(Product p1, Product p2) {
        return sort.get(p1.getClass().getSimpleName()) - sort.get(p2.getClass().getSimpleName());
    }
}
