package br.com.explorer.sample.model;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public enum  Direction {
    N("north"), S("south"), W("west"), E("east");

    private final String description;

    Direction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
