package com.github.alexvishneuski.jsonparsing.simpleinvoicejson.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ContractCommonInfo {

    // contract attributes
    private Integer contractId;
    private Timestamp created;
    private ContractStatus contractStatus;
    //private PayForm payForm;
    //private PayStatus payStatus;
    private BigDecimal totalAmount;

    // customer attributes
    //private Integer customerId;
    //private CustomerType customerType;
    private String customerCompanyName;
    //private String customerLastName;

    // manager attributes
    //private Integer managerId;
    //private String managerLastName;


    public ContractCommonInfo() {
    }

    public Integer getContractId() {
        return contractId;
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
}
