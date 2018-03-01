package enums;

public enum SearchOptions {
    ALL("all"),
    JOURNALS("allJournals"),
    ACTIVEJOURNALS("journalsInActive");

    private String value;

    SearchOptions(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
