package com.github.alexvishneuski.jsonparsing.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersListWithObjectGson implements IUsersList {

    @SerializedName("users")
    private List<UserGson> mUserList;

    @SerializedName("backendVersion")
    private Integer backendVersion;

    @Override
    public List<UserGson> getUsersList() {
        return mUserList;
    }

    public Integer getBackendVersion() {
        return backendVersion;
    }
}
