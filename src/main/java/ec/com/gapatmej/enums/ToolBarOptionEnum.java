package ec.com.gapatmej.enums;

public enum ToolBarOptionEnum {
    QUIT ('Q',"Exit from System"),
    RETURN ('R', "Return ");

    private final Character key;
    private final String description;

    ToolBarOptionEnum(Character key, String description) {
        this.key = key;
        this.description = description;
    }

    public String description() {
        return description;
    }

    public Character key() {
        return key;
    }
}
