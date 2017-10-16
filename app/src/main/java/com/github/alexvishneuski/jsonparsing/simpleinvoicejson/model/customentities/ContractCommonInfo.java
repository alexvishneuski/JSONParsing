package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.customentities;

import com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model.datamodel.ContractStatus;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContractCommonInfo {

    // contract attributes
    @SerializedName("created")
    private Timestamp mCreated;
    @SerializedName("contractStatus")
    private ContractStatus mContractStatus;
    @SerializedName("totalAmount")
    private BigDecimal mTotalAmount;

    // customer attributes
    @SerializedName("customerCompanyName")
    private String mCustomerCompanyName;

    public ContractCommonInfo() {
    }

    public void setCreated(Timestamp pCreated) {
        mCreated = pCreated;
    }

    public void setContractStatus(ContractStatus pContractStatus) {
        mContractStatus = pContractStatus;
    }

    public void setTotalAmount(BigDecimal pTotalAmount) {
        this.mTotalAmount = pTotalAmount;
    }

    public void setCustomerCompanyName(String pCustomerCompanyName) {
        mCustomerCompanyName = pCustomerCompanyName;
    }

    public Timestamp getCreated() {
        return mCreated;
    }

    public ContractStatus getContractStatus() {
        return mContractStatus;
    }

    public BigDecimal getTotalAmount() {
        return mTotalAmount;
    }

    public String getCustomerCompanyName() {
        return mCustomerCompanyName;
    }

    public String convertFromTimestamp2String(Timestamp pTstmp) {
        Date date = new Date(pTstmp.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        final String string = dateFormat.format(date);
        return string;

    }

    @Override
    public String toString() {
        return "ContractCommonInfo{" +
                "created=" + mCreated +
                ", contractStatus=" + mContractStatus +
                ", totalAmount=" + mTotalAmount +
                ", customerCompanyName='" + mCustomerCompanyName + '\'' +
                '}';
    }
}
