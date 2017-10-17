package com.github.alexvishneuski.jsonparsing.backend;

import com.google.appengine.repackaged.com.google.gson.annotations.SerializedName;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Customer {

    @Id
    @SerializedName("id")
    private Long mId;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("patronymic")
    private String mPatronymic;
    @SerializedName("lastName")
    private String mLastName;
    @SerializedName("companyName")
    private String mCompanyName;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("phoneNumber")
    private String mPhoneNumber;
    @SerializedName("customerGroupId")
    private Integer mCustomerGroupId;
    @SerializedName("managerId")
    private Integer mManagerId;

    public Customer() {
    }

    public Customer(Long pId, String pFirstName, String pPatronymic, String pLastName, String pCompanyName, String pAddress, String pPhoneNumber, Integer pCustomerGroupId, Integer pManagerId) {
        this.mId = pId;
        this.mFirstName = pFirstName;
        this.mPatronymic = pPatronymic;
        this.mLastName = pLastName;
        this.mCompanyName = pCompanyName;
        this.mAddress = pAddress;
        this.mPhoneNumber = pPhoneNumber;
        this.mCustomerGroupId = pCustomerGroupId;
        this.mManagerId = pManagerId;
    }

    public Long getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getPatronymic() {
        return mPatronymic;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public Integer getCustomerGroupId() {
        return mCustomerGroupId;
    }

    public Integer getManagerId() {
        return mManagerId;
    }
}
