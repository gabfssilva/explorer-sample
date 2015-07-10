package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.OperationEnum;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@OperationType(OperationEnum.L)
public class TurnLeftOperation implements Operation {
    @Override
    public void apply(Explorer explorer) {
        explorer.setDirection(explorer.getDirection().getLeftDirection());
    }
}
