package br.com.explorer.sample.api;

import br.com.explorer.sample.api.exceptions.RestfulException;
import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.Planet;
import br.com.explorer.sample.repositories.PlanetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static br.com.explorer.sample.util.JsonUtils.asJson;
import static br.com.explorer.sample.util.JsonUtils.asObject;
import static java.lang.Long.valueOf;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class PlanetEndpoint implements SparkConfigurer {
    @Inject
    private PlanetRepository planetRepository;

    @Override
    public void configure() {
        get("/api/v1/planets/:planetId", (request, response) -> {
            Planet planet = planetRepository.get(valueOf(request.params(":planetId")));

            if (planet == null) {
                throw new RestfulException(404, "Not Found");
            }

            response.status(200);
            return asJson(planet);
        });

        post("/api/v1/planets", (request, response) -> {
            Planet planet = asObject(request.body(), Planet.class);
            planetRepository.save(planet);
            response.status(201);
            return asJson(planet);
        });

    }
}
