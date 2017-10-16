package com.github.alexvishneuski.jsonparsing.model.customentities;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ContractDetail {

    @SerializedName("itemName")
    private String mItemName;
    @SerializedName("itemVariantPrice")
    private BigDecimal mItemVariantPrice;

    public ContractDetail() {
    }

    public void setItemName(String pItemName) {
        mItemName = pItemName;
    }

    public void setItemVariantPrice(BigDecimal pItemVariantPrice) {
        mItemVariantPrice = pItemVariantPrice;
    }

    public String getItemName() {
        return mItemName;
    }

    public BigDecimal getItemVariantPrice() {
        return mItemVariantPrice;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "itemName='" + mItemName + '\'' +
                ", itemVariantPrice=" + mItemVariantPrice +
                '}';
    }
}
