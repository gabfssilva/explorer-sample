package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.OperationEnum;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@OperationType(OperationEnum.M)
public class MoveOperation implements Operation {
    @Override
    public void apply(Explorer explorer) {
        explorer.setyPosition(explorer.getyPosition() + explorer.getDirection().getMovementYValue());
        explorer.setxPosition(explorer.getxPosition() + explorer.getDirection().getMovementXValue());
    }
}
