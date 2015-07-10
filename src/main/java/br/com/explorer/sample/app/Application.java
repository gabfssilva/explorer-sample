package br.com.explorer.sample.app;

import br.com.explorer.sample.api.SparkConfigurer;
import br.com.explorer.sample.api.exceptions.RestfulException;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

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

        exception(RestfulException.class, (exception, request, response) -> response.status(((RestfulException) exception).getHttpStatus()));
        after("/api/v1/*", (request, response) -> response.type("application/json"));

        sparkConfigurers.forEach(c -> c.configure());
    }
}
