package br.com.explorer.sample.api;

import br.com.explorer.sample.api.exceptions.RestfulException;
import br.com.explorer.sample.model.Explorer;
import br.com.explorer.sample.model.Planet;
import br.com.explorer.sample.repositories.ExplorerRepository;
import br.com.explorer.sample.repositories.PlanetRepository;
import br.com.explorer.sample.services.OperationChain;
import br.com.explorer.sample.services.OperationChainFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static br.com.explorer.sample.util.JsonUtils.asJson;
import static br.com.explorer.sample.util.JsonUtils.asObject;
import static java.lang.Long.valueOf;
import static spark.Spark.*;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class ExplorerEndpoint implements SparkConfigurer {
    @Inject
    private ExplorerRepository explorerRepository;

    @Inject
    private PlanetRepository planetRepository;

    @Inject
    private OperationChainFactory operationChainFactory;

    @Override
    public void configure() {
        get("/api/v1/planets/:planetId/explorers/:explorerId", (request, response) -> {
            Planet planet = planetRepository.get(valueOf(request.params(":planetId")));

            if (planet == null) {
                throw new RestfulException(404, "Not Found");
            }

            Explorer explorer = explorerRepository.get(valueOf(request.params(":explorerId")));

            if (explorer == null) {
                throw new RestfulException(404, "Not Found");
            }

            response.status(200);
            return asJson(explorer);
        });

        post("/api/v1/planets/:planetId/explorers", (request, response) -> {
            Explorer explorer = asObject(request.body(), Explorer.class);

            Planet planet = planetRepository.get(valueOf(request.params(":planetId")));

            if (planet == null) {
                throw new RestfulException(404, "Not Found");
            }

            explorer.setPlanet(planet);
            explorerRepository.save(explorer);
            response.status(201);
            return asJson(explorer);
        });

        put("/api/v1/planets/:planetId/explorers/:explorerId", (request, response) -> {
            Planet planet = planetRepository.get(valueOf(request.params(":planetId")));

            if (planet == null) {
                throw new RestfulException(404, "Not Found");
            }

            Explorer explorer = explorerRepository.get(valueOf(request.params(":explorerId")));

            if (explorer == null) {
                throw new RestfulException(404, "Not Found");
            }

            Explorer explorerRequest = asObject(request.body(), Explorer.class);
            OperationChain operationChain = operationChainFactory.operationChain(explorerRequest.getOperations());
            operationChain.start(explorer);
            explorerRepository.save(explorer);
            response.status(200);
            return asJson(explorer);
        });

        after("/api/v1/*", (request, response) -> response.type("application/json"));
    }
}
