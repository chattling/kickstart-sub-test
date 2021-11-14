package com.example.kickstartsubtest.resolvers;

import com.example.kickstartsubtest.publishers.MyPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class MyQueryResolver implements GraphQLQueryResolver {

    @Autowired
    MyPublisher myPublisher;

    public String ping() {
        myPublisher.publish("pong");
        return "pong";
    }
}
