package org.unsw.eva;

/**
 *
 * @author shrimpy
 */
public enum ErrorCode {

    SERVER_ERROR("Server Error"),
    CONNECTION_ERROR("Connection Error"),
    UNKNOWN_ERROR("Unknown Error"),
    NONE("No Error");
    private String code;

    private ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
