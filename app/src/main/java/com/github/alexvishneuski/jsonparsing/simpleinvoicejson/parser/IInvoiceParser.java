package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;

import java.util.List;

public interface IInvoiceParser {

    Invoice parse() throws Exception;

    List<Invoice> parce() throws Exception;
}
