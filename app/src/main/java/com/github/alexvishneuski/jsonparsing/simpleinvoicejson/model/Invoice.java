package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import java.util.List;

public class Invoice {

    //id of an invoice
    private Integer invoiceNumber;

    private ContractCommonInfo commonInfo;

    private List<ContractDetail> details;

    public Invoice() {
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public ContractCommonInfo getCommonInfo() {
        return commonInfo;
    }

    public List<ContractDetail> getDetails() {
        return details;
    }
}
