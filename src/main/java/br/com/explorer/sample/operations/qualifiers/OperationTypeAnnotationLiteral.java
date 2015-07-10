package br.com.explorer.sample.operations.qualifiers;

import br.com.explorer.sample.model.OperationEnum;
import br.com.explorer.sample.operations.OperationType;

import javax.enterprise.util.AnnotationLiteral;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class OperationTypeAnnotationLiteral extends AnnotationLiteral<OperationType> implements OperationType {
    private OperationEnum value;

    public OperationTypeAnnotationLiteral(OperationEnum value) {
        this.value = value;
    }

    public static OperationTypeAnnotationLiteral operationType(OperationEnum value) {
        return new OperationTypeAnnotationLiteral(value);
    }

    @Override
    public OperationEnum value() {
        return value;
    }
}
