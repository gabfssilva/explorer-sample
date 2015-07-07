package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Direction;
import br.com.explorer.sample.model.Explorer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class TurnRightOperationTest {

    @Test
    public void shouldChooseTheRightDirection() throws Exception {
        TurnRightOperation operation = new TurnRightOperation();
        Explorer explorer = new Explorer();
        explorer.setDirection(Direction.N);
        operation.apply(explorer);

        assertThat(explorer.getDirection(), equalTo(Direction.N.getRightDirection()));
    }
}