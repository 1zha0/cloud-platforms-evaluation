package org.unsw.eva;

/**
 *
 * @author shrimpy
 */
public enum FileSuffix {

    CSV("csv");
    private String value;

    private FileSuffix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
