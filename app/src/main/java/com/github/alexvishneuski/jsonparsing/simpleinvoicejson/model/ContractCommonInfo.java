package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContractCommonInfo {

    // contract attributes
    //private Integer contractId;
    @SerializedName("created")
    private Timestamp created;
    @SerializedName("contractStatus")
    private ContractStatus contractStatus;
    //private PayForm payForm;
    //private PayStatus payStatus;
    @SerializedName("totalAmount")
    private BigDecimal totalAmount;

    // customer attributes
    //private Integer customerId;
    //private CustomerType customerType;
    @SerializedName("customerCompanyName")
    private String customerCompanyName;
    //private String customerLastName;

    // manager attributes
    //private Integer managerId;
    //private String managerLastName;


    public ContractCommonInfo() {
    }


    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }


    public Timestamp getCreated() {
        return created;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public String convertFromTimestamp2String(Timestamp tstmp) {
        Date date = new Date(tstmp.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        final String string = dateFormat.format(date);
        return string;

    }

    @Override
    public String toString() {
        return "ContractCommonInfo{" +
                "created=" + created +
                ", contractStatus=" + contractStatus +
                ", totalAmount=" + totalAmount +
                ", customerCompanyName='" + customerCompanyName + '\'' +
                '}';
    }
}
