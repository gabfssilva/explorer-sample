package br.com.explorer.sample.app;

import br.com.explorer.sample.api.SparkConfigurer;
import br.com.explorer.sample.api.exceptions.RestfulException;
import br.com.explorer.sample.operations.exceptions.InvalidPositionException;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.explorer.sample.util.JsonUtils.asJson;
import static java.util.Arrays.asList;
import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.SparkBase.port;
import static spark.SparkBase.threadPool;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
@ApplicationScoped
public class Application {
    @Inject
    @Any
    private Instance<SparkConfigurer> sparkConfigurers;

    public void main(@Observes ContainerInitialized event) {
        port(9090);
        threadPool(100);

        exception(InvalidPositionException.class, (exception, request, response) -> {
            Map<String, String> error = new HashMap<>();
            error.put("message", exception.getMessage());
            response.status(400);
            response.body(asJson(asList(error)));
        });

        exception(RestfulException.class, (exception, request, response) -> response.status(((RestfulException) exception).getHttpStatus()));
        after("/api/v1/*", (request, response) -> response.type("application/json"));

        sparkConfigurers.forEach(c -> c.configure());
    }
}
