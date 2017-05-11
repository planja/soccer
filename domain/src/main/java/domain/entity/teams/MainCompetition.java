package domain.entity.teams;

/**
 * Created by ShchykalauM on 11.05.2017.
 */
public enum MainCompetition {

    RUSSIA(0, "Россия"),
    CHAMPIONS_LEAGUE(1, "Лига Чемпионов"),
    EUROPE_LEAGUE(2, "Лига Европы"),
    ENGLAND(3, "Англия"),
    SPAIN(4, "Испания"),
    ITALY(5, "Италия"),
    GERMANY(6, "Германия"),
    UKRAINE(7, "Украина"),
    FRANCE(8, "Франция"),
    OTHER(9, "Другие");

    private final int value;
    private final String text;

    MainCompetition(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

}
