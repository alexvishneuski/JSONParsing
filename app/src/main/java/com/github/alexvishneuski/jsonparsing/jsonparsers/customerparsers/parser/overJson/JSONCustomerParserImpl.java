package com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.overJson;

import com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.ICustomerParser;


public class JSONCustomerParserImpl implements ICustomerParser {
    private final String mSource;

    public JSONCustomerParserImpl(final String pSource) {
        mSource = pSource;
    }
}
