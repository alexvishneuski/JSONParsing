package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import java.math.BigDecimal;

public class ContractDetail {

    //private Integer contractId;

    //private Integer itemVariantId;

    private String itemName;
    private BigDecimal itemVariantPrice;
    //private Integer itemVariantQuantity;
    //private BigDecimal itemVariantTotalPrice;


    public ContractDetail() {
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemVariantPrice() {
        return itemVariantPrice;
    }
}
