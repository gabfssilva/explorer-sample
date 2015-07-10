package br.com.explorer.sample.model;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public enum OperationEnum {
    R("right"), L("left"), M("move");

    private final String description;

    OperationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
