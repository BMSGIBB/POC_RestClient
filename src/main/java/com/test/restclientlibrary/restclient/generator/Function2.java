package com.test.restclientlibrary.restclient.generator;

@FunctionalInterface
public interface Function2<A, B, C> {
    C apply(A a, B b);
}
