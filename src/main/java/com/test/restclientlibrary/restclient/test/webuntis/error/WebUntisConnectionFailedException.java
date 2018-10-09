package com.test.restclientlibrary.restclient.test.webuntis.error;

public class WebUntisConnectionFailedException extends Exception{
    public WebUntisConnectionFailedException() {
        super();
    }

    public WebUntisConnectionFailedException(String message) {
        super(message);
    }

    public WebUntisConnectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebUntisConnectionFailedException(Throwable cause) {
        super(cause);
    }

    protected WebUntisConnectionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
