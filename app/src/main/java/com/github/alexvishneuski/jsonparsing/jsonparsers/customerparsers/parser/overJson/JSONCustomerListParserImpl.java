package com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.overJson;

import com.github.alexvishneuski.jsonparsing.jsonparsers.customerparsers.parser.ICustomerListParser;

import java.io.InputStream;


public class JSONCustomerListParserImpl implements ICustomerListParser {

    private final InputStream mInputStream;

    public JSONCustomerListParserImpl(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

}
