package com.test.restclientlibrary.restclient.factory;

import retrofit2.Converter;

public interface IConverterFactory {
    Converter.Factory getFactory(Class<? extends Converter.Factory> factoryClass);
}
