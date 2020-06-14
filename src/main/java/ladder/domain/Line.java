package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    private List<Boolean> points;

    public Line(int countOfPerson) {
        this.points = createLine(countOfPerson);
    }

    public static Line create(int countOfPerson) {
        return new Line(countOfPerson);
    }

    private List<Boolean> createLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.rangeClosed(0, countOfPerson)
                .mapToObj(i -> false)
                .reduce((point, first) -> {
                    points.add(point);
                    return checkLineOverlap(point);
                });
        return points;
    }

    boolean checkLineOverlap(Boolean point) {
        if (point) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
