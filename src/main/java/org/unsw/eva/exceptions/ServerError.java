package org.unsw.eva.exceptions;

/**
 *
 * @author shrimpy
 */
public class ServerError extends Error {

    public ServerError(Throwable cause) {
        super(cause);
    }

    public ServerError(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerError(String message) {
        super(message);
    }
}
