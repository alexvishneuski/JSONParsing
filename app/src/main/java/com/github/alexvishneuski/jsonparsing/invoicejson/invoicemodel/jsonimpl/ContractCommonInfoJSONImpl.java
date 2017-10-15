package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.jsonimpl;

import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.ContractStatus;
import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IContractCommonInfo;
import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IListContractDetail;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ContractCommonInfoJSONImpl implements IContractCommonInfo {
    @Override
    public Integer getContractId() {
        return null;
    }

    @Override
    public Timestamp getCreated() {
        return null;
    }

    @Override
    public ContractStatus getContractStatus() {
        return null;
    }

    @Override
    public String getCustomerCompanyName() {
        return null;
    }

    @Override
    public BigDecimal getTotalAmount() {
        return null;
    }
}
