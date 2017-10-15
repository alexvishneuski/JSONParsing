package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;

import java.util.List;

public class GSONInvoiceParserImpl implements IInvoiceParser {

    private final String mSource;

    public GSONInvoiceParserImpl(final String pSource) {
        mSource = pSource;
    }

    @Override
    public Invoice parse() throws Exception {
        return null;
    }

    @Override
    public List<Invoice> parce() throws Exception {
        return null;
    }
}
