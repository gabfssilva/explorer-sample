package br.com.explorer.sample.operations.exceptions;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
