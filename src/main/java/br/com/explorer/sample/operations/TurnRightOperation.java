package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Explorer;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@OperationType("R")
public class TurnRightOperation implements Operation {
    @Override
    public void apply(Explorer explorer) {
        explorer.setDirection(explorer.getDirection().getRightDirection());
    }
}
