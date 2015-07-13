package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.OperationEnum;
import br.com.explorer.sample.model.Planet;
import br.com.explorer.sample.operations.exceptions.InvalidPositionException;

import static java.lang.String.format;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@OperationType(OperationEnum.M)
public class MoveOperation implements Operation {
    @Override
    public void apply(Explorer explorer) {
        Planet planet = explorer.getPlanet();

        int yPosition = explorer.getyPosition() + explorer.getDirection().getMovementYValue();

        if(yPosition > planet.getHeight()){
            throw new InvalidPositionException(
                            format("The %s planet is %dx%d, you cannot move Y to %d",
                                    planet.getName(), planet.getWidth(), planet.getHeight(), yPosition));
        }

        int xPosition = explorer.getxPosition() + explorer.getDirection().getMovementXValue();

        if(xPosition > planet.getWidth()){
            throw new InvalidPositionException(
                            format("The %s planet is %dx%d, you cannot move X to %d",
                                    planet.getName(), planet.getWidth(), planet.getHeight(), xPosition));
        }

        explorer.setyPosition(yPosition);
        explorer.setxPosition(xPosition);
    }
}
