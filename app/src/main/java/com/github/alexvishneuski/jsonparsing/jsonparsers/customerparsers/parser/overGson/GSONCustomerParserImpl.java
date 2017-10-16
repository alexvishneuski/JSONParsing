package com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.overGson;

import com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.ICustomerParser;


public class GSONCustomerParserImpl implements ICustomerParser {
    private final String mSource;

    public GSONCustomerParserImpl(final String pSource) {
        mSource = pSource;
    }

}
