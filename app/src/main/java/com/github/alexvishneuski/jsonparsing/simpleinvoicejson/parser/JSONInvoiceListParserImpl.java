package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;

import java.io.InputStream;
import java.util.List;

public class JSONInvoiceListParserImpl implements IInvoiceListParser {

    private final InputStream mInputStream;

    public JSONInvoiceListParserImpl(InputStream pInputStream) {
        this.mInputStream = pInputStream;
    }

    @Override
    public List<Invoice> parce() throws Exception {
        return null;
    }

}
