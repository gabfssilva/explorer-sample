package br.com.explorer.sample.services;

import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.operations.Operation;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class OperationChain {
    private List<Operation> operations;

    public OperationChain(List<Operation> operations) {
        this.operations = operations;
    }

    public OperationChain(Operation... operations) {
        this(asList(operations));
    }

    public void start(Explorer explorer){
        operations.forEach(o -> o.apply(explorer));
    }
}
