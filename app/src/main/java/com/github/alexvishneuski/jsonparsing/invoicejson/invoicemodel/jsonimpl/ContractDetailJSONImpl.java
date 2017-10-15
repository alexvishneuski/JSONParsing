package com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.jsonimpl;

import com.github.alexvishneuski.jsonparsing.invoicejson.invoicemodel.IContractDetail;

import org.json.JSONObject;

import java.math.BigDecimal;

public class ContractDetailJSONImpl implements IContractDetail {

    private static final String CONTRACT_ID = "contractId";
    private static final String ITEM_NAME = "itemName";
    private static final String ITEM_VARIANT_PRICE = "itemVariantPrice";

    private final JSONObject mJsonObject;

    public ContractDetailJSONImpl(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public Integer getContractId() {
        return mJsonObject.optInt(CONTRACT_ID);
    }

    @Override
    public String getItemName() {
        return mJsonObject.optString(ITEM_NAME);

    }

    @Override
    public BigDecimal getItemVariantPrice() {
        return new BigDecimal(mJsonObject.optDouble(ITEM_VARIANT_PRICE));
    }
}




