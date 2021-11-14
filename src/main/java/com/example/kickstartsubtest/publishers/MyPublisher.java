package com.example.kickstartsubtest.publishers;

import org.springframework.stereotype.Component;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
public class MyPublisher {
    final Flux<String> publisher;
    FluxSink<String> emitter;

    public MyPublisher() {
        Flux<String> pongFlux = Flux.create(myFluxSink -> {
            emitter = myFluxSink;
        });
        ConnectableFlux<String> pingFlux = pongFlux.share().publish();
        pingFlux.connect();
        
        publisher = Flux.from(pingFlux);
    }

    public void publish(String what) {
        System.out.println("publishing: " + what);
        emitter.next(what);
    }

    public Flux<String> getPublisher() {
        return publisher;
    }
}
