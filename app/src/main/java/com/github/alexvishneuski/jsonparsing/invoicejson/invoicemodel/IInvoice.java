package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel;

import java.util.List;

public interface IInvoice {

    Integer getInvoiceNumber();

    IContractCommonInfo getCommonInfo();

    List<IContractDetail> getDetails();

}
