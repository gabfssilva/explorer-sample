package br.com.explorer.sample.repositories;

import br.com.explorer.sample.model.Planet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class PlanetRepository {
    private Long nextId = 0l;
    private Map<Long, Planet> planets;

    @PostConstruct
    public void init(){
        planets = new HashMap<>();
    }

    public void save(Planet planet){
        planet.setId(planet.getId() == null ? generateId() : planet.getId());
        this.planets.put(planet.getId(), planet);
    }

    public Planet get(Long id){
        return this.planets.get(id);
    }

    private synchronized Long generateId(){
        return ++nextId;
    }
}
