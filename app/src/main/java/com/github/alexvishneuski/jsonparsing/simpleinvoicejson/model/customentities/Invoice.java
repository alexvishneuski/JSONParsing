package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.customentities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Invoice {

    @SerializedName("invoiceNumber")
    private Integer mInvoiceNumber;
    @SerializedName("commonInfo")
    private ContractCommonInfo mCommonInfo;
    @SerializedName("details")
    private List<ContractDetail> mDetails;

    public Invoice() {
    }

    public void setInvoiceNumber(Integer pInvoiceNumber) {
        this.mInvoiceNumber = pInvoiceNumber;
    }

    public void setCommonInfo(ContractCommonInfo pCommonInfo) {
        mCommonInfo = pCommonInfo;
    }

    public void setDetails(List<ContractDetail> details) {
        mDetails = details;
    }

    public Integer getInvoiceNumber() {
        return mInvoiceNumber;
    }

    public ContractCommonInfo getCommonInfo() {
        return mCommonInfo;
    }

    public List<ContractDetail> getDetails() {
        return mDetails;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + mInvoiceNumber +
                ", commonInfo=" + mCommonInfo +
                ", details=" + mDetails +
                '}';
    }
}
