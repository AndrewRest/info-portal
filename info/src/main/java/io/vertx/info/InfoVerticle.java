package io.vertx.info;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.domain.Info;
import io.vertx.domain.Weather;

public class InfoVerticle extends AbstractVerticle {
    
    public static final String weatherService = "/api/weather";

    @Override
    public void start(Future<Void> fut) throws Exception {
        // Create a router object.
        Router router = Router.router(vertx);

        router.get("/api/info").handler(context -> {
            WebClient client = WebClient.create(vertx);
            
            client
                .get(8080, "localhost", weatherService)
                .as(BodyCodec.json(Weather.class))
                .send(ar -> {
                    if (ar.succeeded()) {
                        HttpResponse<Weather> response = ar.result();
    
                        Weather weather = response.body();
    
                        context.response()
                            .putHeader("content-type", "application/json; charset=utf-8")
                            .end(Json.encodePrettily(
                                    new Info("Banging your head against a wall for one hour burns 150 calories.",
                                              weather)));
                    } else {
                        System.out.println("Something went wrong " + ar.cause().getMessage());
                    }
            });
        });

        vertx.createHttpServer()
            .requestHandler(router::accept).listen(
                config().getInteger("http.port", 8081), result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }

}
