package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel;

import java.math.BigDecimal;

public interface IContractDetail {

    Integer getContractId();

    //Integer getItemVariantId();

    String getItemName();

    BigDecimal getItemVariantPrice();

    //Integer getItemVariantQuantity();

    //BigDecimal getItemVariantTotalPrice();
}
