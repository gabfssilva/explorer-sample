package br.com.explorer.sample.services;

import br.com.explorer.sample.model.Direction;
import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.Planet;
import br.com.explorer.sample.operations.MoveOperation;
import br.com.explorer.sample.operations.TurnLeftOperation;
import br.com.explorer.sample.operations.TurnRightOperation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class OperationChainTest {

    @Test
    public void testLMLMLMLMM() throws Exception {
        TurnLeftOperation leftOperation = new TurnLeftOperation();
        MoveOperation moveOperation = new MoveOperation();

        Explorer explorer = new Explorer();

        explorer.setPlanet(getPlanet());
        explorer.setxPosition(1);
        explorer.setyPosition(2);
        explorer.setDirection(Direction.N);

        OperationChain operationChain = new OperationChain(leftOperation,
                moveOperation,
                leftOperation,
                moveOperation,
                leftOperation,
                moveOperation,
                leftOperation,
                moveOperation,
                moveOperation);

        operationChain.start(explorer);

        assertThat(explorer.getDirection(), equalTo(Direction.N));
        assertThat(explorer.getxPosition(), equalTo(1));
        assertThat(explorer.getyPosition(), equalTo(3));
    }

    @Test
    public void testMMRMMRMRRM() throws Exception {
        TurnRightOperation rightOperation = new TurnRightOperation();
        MoveOperation moveOperation = new MoveOperation();

        Explorer explorer = new Explorer();

        explorer.setPlanet(getPlanet());
        explorer.setxPosition(3);
        explorer.setyPosition(3);
        explorer.setDirection(Direction.E);

        OperationChain operationChain = new OperationChain(
                moveOperation,
                moveOperation,
                rightOperation,
                moveOperation,
                moveOperation,
                rightOperation,
                moveOperation,
                rightOperation,
                rightOperation,
                moveOperation);

        operationChain.start(explorer);

        assertThat(explorer.getDirection(), equalTo(Direction.E));
        assertThat(explorer.getxPosition(), equalTo(5));
        assertThat(explorer.getyPosition(), equalTo(1));
    }

    private Planet getPlanet() {
        Planet planet = new Planet();
        planet.setHeight(5);
        planet.setWidth(5);
        return planet;
    }
}