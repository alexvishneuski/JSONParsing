package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.parser;

import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UserGson;
import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.Invoice;

public interface IInvoiceParser {

    Invoice parse() throws Exception;


}
