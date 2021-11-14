package com.example.kickstartsubtest.resolvers;

import com.example.kickstartsubtest.publishers.MyPublisher;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;

@Component
public class MySubscriptionResolver implements GraphQLSubscriptionResolver {
    @Autowired
    MyPublisher myPublisher;

    public Publisher<String> pong() {
        return myPublisher.getPublisher();
    }
}
