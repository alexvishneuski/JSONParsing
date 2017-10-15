package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.GSONInvoiceParserImpl;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceListParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.JSONInvoiceParserImpl;

import java.io.InputStream;


public class InvoiceParserFactory {


    public IInvoiceParser createJsonParser(String pSource) {
        return new JSONInvoiceParserImpl(pSource);
    }


    public IInvoiceParser createGsonParser(String pSource) {
        return new GSONInvoiceParserImpl(pSource);
    }

    }
