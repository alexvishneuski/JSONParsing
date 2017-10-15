package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ContractDetail {

    //private Integer contractId;

    //private Integer itemVariantId;
    @SerializedName("itemName")
    private String itemName;
    @SerializedName("itemVariantPrice")
    private BigDecimal itemVariantPrice;
    //private Integer itemVariantQuantity;
    //private BigDecimal itemVariantTotalPrice;


    public ContractDetail() {
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemVariantPrice(BigDecimal itemVariantPrice) {
        this.itemVariantPrice = itemVariantPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemVariantPrice() {
        return itemVariantPrice;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "itemName='" + itemName + '\'' +
                ", itemVariantPrice=" + itemVariantPrice +
                '}';
    }
}
