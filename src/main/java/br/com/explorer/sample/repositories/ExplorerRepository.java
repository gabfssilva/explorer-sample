package br.com.explorer.sample.repositories;

import br.com.explorer.sample.model.Explorer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class ExplorerRepository {
    private Long nextId = 0l;
    private Map<Long, Explorer> explorers;

    @PostConstruct
    public void init(){
        explorers = new HashMap<>();
    }

    public void save(Explorer explorer){
        explorer.setId(generateId());
        this.explorers.put(explorer.getId(), explorer);
    }

    public Explorer get(Long id){
        return this.explorers.get(id);
    }

    private synchronized Long generateId(){
        return ++nextId;
    }
}
