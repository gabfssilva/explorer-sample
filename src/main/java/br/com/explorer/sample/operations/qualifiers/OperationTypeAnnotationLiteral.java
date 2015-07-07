package br.com.explorer.sample.operations.qualifiers;

import br.com.explorer.sample.operations.OperationType;

import javax.enterprise.util.AnnotationLiteral;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class OperationTypeAnnotationLiteral extends AnnotationLiteral<OperationType> implements OperationType {
    private String value;

    public OperationTypeAnnotationLiteral(String value) {
        this.value = value;
    }

    public static OperationTypeAnnotationLiteral operationType(String value) {
        return new OperationTypeAnnotationLiteral(value);
    }

    @Override
    public String value() {
        return value;
    }
}
