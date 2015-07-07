package br.com.explorer.sample.operations;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface OperationType {
    String value();
}
