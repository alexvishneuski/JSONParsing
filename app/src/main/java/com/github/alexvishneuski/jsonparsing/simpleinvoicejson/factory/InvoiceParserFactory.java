package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.factory;

import com.github.alexvishneuski.jsonparsing.json.parser.IUserParser;
import com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl.UserGsonParser;
import com.github.alexvishneuski.jsonparsing.json.parser.jsonparserimpl.UserJsonObjectParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.GSONInvoiceParserImpl;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.IInvoiceParser;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser.JSONInvoiceParserImpl;


public class InvoiceParserFactory {


    public IInvoiceParser createJsonParser(String pSource) {
        return new JSONInvoiceParserImpl(pSource);
    }


    public IInvoiceParser createGsonParser(String pSource) {
        return new GSONInvoiceParserImpl(pSource);
    }

}
