package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.customentities.Invoice;

import java.util.List;

public interface IInvoiceListParser {

    List<Invoice> parce() throws Exception;
}
