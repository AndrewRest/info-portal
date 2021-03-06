package io.vertx.weather;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

import io.vertx.domain.Weather;

public class WeatherVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) throws Exception {
        // Create a router object.
        Router router = Router.router(vertx);

        router.get("/api/weather").handler(context -> {
            context.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(new Weather(15, "LIGHT SNOW")));
        });

        // Create the HTTP server and pass the "accept" method to the request
        // handler.
        vertx.createHttpServer()
            .requestHandler(router::accept).listen(
                // Retrieve the port from the configuration,
                // default to 8080.
                config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }
}
