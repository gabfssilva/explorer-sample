package br.com.explorer.sample.operations;

import br.com.explorer.sample.model.Explorer;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public interface Operation {
    void apply(Explorer explorer);
}
