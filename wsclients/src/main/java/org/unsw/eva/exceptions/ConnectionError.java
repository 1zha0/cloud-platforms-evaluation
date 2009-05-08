package org.unsw.eva.exceptions;

/**
 *
 * @author shrimpy
 */
public class ConnectionError extends Error {

    public ConnectionError(Throwable cause) {
        super(cause);
    }

    public ConnectionError(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionError(String message) {
        super(message);
    }
}
