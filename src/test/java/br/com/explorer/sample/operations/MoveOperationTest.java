package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Direction;
import br.com.explorer.sample.model.Explorer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class MoveOperationTest {

    @Test
    public void positionShouldBeZeroOne(){
        MoveOperation operation = new MoveOperation();

        Explorer explorer = new Explorer();
        explorer.setDirection(Direction.N);
        explorer.setxPosition(0);
        explorer.setyPosition(0);

        operation.apply(explorer);

        assertThat(explorer.getxPosition(), equalTo(0));
        assertThat(explorer.getyPosition(), equalTo(1));
    }

    @Test
    public void positionShouldBeOneOne(){
        MoveOperation operation = new MoveOperation();

        Explorer explorer = new Explorer();
        explorer.setDirection(Direction.N);
        explorer.setxPosition(1);
        explorer.setyPosition(0);

        operation.apply(explorer);

        assertThat(explorer.getxPosition(), equalTo(1));
        assertThat(explorer.getyPosition(), equalTo(1));
    }

    @Test
    public void positionShouldBeTwoOne(){
        MoveOperation operation = new MoveOperation();

        Explorer explorer = new Explorer();
        explorer.setDirection(Direction.S);
        explorer.setxPosition(1);
        explorer.setyPosition(3);

        operation.apply(explorer);

        assertThat(explorer.getxPosition(), equalTo(1));
        assertThat(explorer.getyPosition(), equalTo(2));
    }
}