package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Direction;
import br.com.explorer.sample.model.Explorer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class TurnLeftOperationTest {

    @Test
    public void shouldChooseTheLeftDirection() throws Exception {
        TurnLeftOperation operation = new TurnLeftOperation();
        Explorer explorer = new Explorer();
        explorer.setDirection(Direction.N);
        operation.apply(explorer);

        assertThat(explorer.getDirection(), equalTo(Direction.N.getLeftDirection()));
    }
}