package com.github.alexvishneuski.jsonparsing.model.datamodel;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    private Integer mId;
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

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getPatronymic() {
        return mPatronymic;
    }

    public void setPatronymic(String patronymic) {
        mPatronymic = patronymic;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public Integer getCustomerGroupId() {
        return mCustomerGroupId;
    }

    public void setCustomerGroupId(Integer customerGroupId) {
        mCustomerGroupId = customerGroupId;
    }

    public Integer getManagerId() {
        return mManagerId;
    }

    public void setManagerId(Integer managerId) {
        mManagerId = managerId;
    }


}
