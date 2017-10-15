package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.jsonimpl;

import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IContractCommonInfo;
import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IContractDetail;
import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IInvoice;

import java.util.List;

public class InvoiceJSONImpl implements IInvoice {
    @Override
    public Integer getInvoiceNumber() {
        return null;
    }

    @Override
    public IContractCommonInfo getCommonInfo() {
        return null;
    }

    @Override
    public List<IContractDetail> getDetails() {
        return null;
    }
}
