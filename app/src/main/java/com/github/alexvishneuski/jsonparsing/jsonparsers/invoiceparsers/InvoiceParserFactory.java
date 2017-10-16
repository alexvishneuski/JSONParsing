package com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers;

import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.IInvoiceListParser;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.IInvoiceParser;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overGson.GSONInvoiceListParserImpl;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overGson.GSONInvoiceParserImpl;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overJson.JSONInvoiceListParserImpl;
import com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser.overJson.JSONInvoiceParserImpl;

import java.io.InputStream;


public class InvoiceParserFactory {

    public IInvoiceParser createJsonParser(String pSource) {
        return new JSONInvoiceParserImpl(pSource);
    }

    public IInvoiceParser createGsonParser(String pSource) {
        return new GSONInvoiceParserImpl(pSource);
    }

    public IInvoiceListParser createJsonListParser(InputStream pSource) {
        return new JSONInvoiceListParserImpl(pSource);
    }

    public IInvoiceListParser createGsonListParser(InputStream pSource) {
        return new GSONInvoiceListParserImpl(pSource);
    }
}
