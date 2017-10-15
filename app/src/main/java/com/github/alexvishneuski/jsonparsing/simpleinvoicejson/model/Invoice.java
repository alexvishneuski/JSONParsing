package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import java.io.Serializable;
import java.util.List;

public class Invoice implements Serializable {

    //id of an invoice
    private Integer invoiceNumber;

    private ContractCommonInfo commonInfo;

    private List<ContractDetail> details;

    public Invoice() {
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCommonInfo(ContractCommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    public void setDetails(List<ContractDetail> details) {
        this.details = details;
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
