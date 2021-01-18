package ec.com.gapatmej.enums;

public enum OptionMenuEnum {

    ADD_GRAPH("1","Add a Graph"),
    CALCULATE_DISTANCE("2","Calculate the Distance between Stations"),
    TRAVELS_MAXIMUM_STOPS("3","Numbers of travels starting on ... and ending on ... with maximum ... stops"),
    TRAVELS_EXACTLY_STOPS("4","Numbers of travels starting on ... and ending on ... with exactly ... stops"),
    TRAVEL_SHORTEST("5","The shortest travel between Stations"),
    TRAVELS_MAXIMUM_DISTANCE("6","Get Travels between Stations with a distance less than ...");


    private final String key;
    private final String description;

    OptionMenuEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String key() {
        return key;
    }

    public String description() { return description; }
}
