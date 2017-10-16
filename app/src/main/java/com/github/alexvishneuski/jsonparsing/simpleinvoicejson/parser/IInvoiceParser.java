package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.customentities.Invoice;

public interface IInvoiceParser {

    Invoice parse() throws Exception;


}
