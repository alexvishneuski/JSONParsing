package com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.overGson;

import com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.ICustomerListParser;

import java.io.InputStream;

public class GSONCustomerListParserImpl implements ICustomerListParser {
    private final InputStream mInputStream;

    public GSONCustomerListParserImpl(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

}
