package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int ladderHeight, int countOfPerson) {
        checkLadderHeight(ladderHeight);
        this.ladder = IntStream.range(0, ladderHeight)
                .mapToObj(i -> Line.create(countOfPerson))
                .collect(Collectors.toList());
    }

    public static Ladder create(int ladderHeight, int countOfPerson) {
        return new Ladder(ladderHeight, countOfPerson);
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리 길이가 0 이하 입니다.");
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

}
