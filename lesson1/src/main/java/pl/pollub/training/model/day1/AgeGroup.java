package pl.pollub.training.model.day1;

/**
 * Created by Wlad on 25.04.2016.
 */
public enum AgeGroup {

    CHILDREN(0, 12), TEENAGER(12, 18), ADULT(18, 60), SENIOR(60, 100);

    private int from;
    private int to;

    AgeGroup(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public static AgeGroup getAgeGroup(int age) {
        for (AgeGroup group : values()) {
            if (group.getFrom() <= age && group.getTo() >= age) {
                return group;
            }
        }
        throw new IllegalArgumentException();
    }
}
