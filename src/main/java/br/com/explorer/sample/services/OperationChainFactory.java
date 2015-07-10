package br.com.explorer.sample.services;

import br.com.explorer.sample.model.OperationEnum;
import br.com.explorer.sample.operations.Operation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.List;

import static br.com.explorer.sample.operations.qualifiers.OperationTypeAnnotationLiteral.operationType;
import static java.util.stream.Collectors.toList;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class OperationChainFactory {
    @Inject
    @Any
    private Instance<Operation> operations;

    public OperationChain operationChain(List<OperationEnum> operationEnumList){
        List<Operation> list = operationEnumList
                .stream()
                .map(e -> operations.select(operationType(e)).get())
                .collect(toList());

        return new OperationChain(list);
    }
}
