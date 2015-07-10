package br.com.explorer.sample.api.exceptions;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class RestfulException extends RuntimeException {
    private int httpStatus;
    private String response;

    public RestfulException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public RestfulException(int httpStatus, String response, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.response = response;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getResponse() {
        return response;
    }
}
