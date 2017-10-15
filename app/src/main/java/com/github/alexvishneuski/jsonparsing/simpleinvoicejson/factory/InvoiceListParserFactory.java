package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.GSONInvoiceListParserImpl;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.GSONInvoiceParserImpl;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceListParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.JSONInvoiceListParserImpl;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.JSONInvoiceParserImpl;

import java.io.InputStream;


public class InvoiceListParserFactory {



    public IInvoiceListParser createJsonListParser(InputStream pSource) {
        return new JSONInvoiceListParserImpl(pSource);
    }


    public IInvoiceListParser createGsonListParser(InputStream pSource) {
        return new GSONInvoiceListParserImpl(pSource);
    }

    }
