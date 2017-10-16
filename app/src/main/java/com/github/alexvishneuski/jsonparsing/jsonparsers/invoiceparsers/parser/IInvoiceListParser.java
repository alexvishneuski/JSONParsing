package com.github.alexvishneuski.jsonparsing.jsonparsers.invoiceparsers.parser;

import com.github.alexvishneuski.jsonparsing.model.customentities.Invoice;

import java.util.List;

public interface IInvoiceListParser {

    List<Invoice> parce() throws Exception;
}
