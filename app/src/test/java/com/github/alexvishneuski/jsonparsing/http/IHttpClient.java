package com.github.alexvishneuski.jsonparsing.http;

import java.io.InputStream;
//IHttpClient interface creating
public interface IHttpClient {

    InputStream request(String url);
}
