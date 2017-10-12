package com.github.alexvishneuski.jsonparsing.http;

import java.io.InputStream;

public class HttpClient implements IHttpClient {

    @Override
    public InputStream request(String url) {
        throw new IllegalStateException("implements httpClient");
    }
}
