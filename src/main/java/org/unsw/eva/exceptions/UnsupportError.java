package org.unsw.eva.exceptions;

/**
 *
 * @author shrimpy
 */
public class UnsupportError extends Error {

    public UnsupportError(Throwable cause) {
        super(cause);
    }

    public UnsupportError(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportError(String message) {
        super(message);
    }
}
