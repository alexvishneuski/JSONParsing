package com.github.alexvishneuski.jsonparsing.json.model.gsonimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UserGson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersListWithObjectGson implements IUsersList {

    @SerializedName("users")
    private List<UserGson> mUserList;

    @SerializedName("backendVersion")
    private Integer backendVersion;

    public UsersListWithObjectGson(){}

    @Override
    public List<UserGson> getUsersList() {
        return mUserList;
    }

    public Integer getBackendVersion() {
        return backendVersion;
    }
}
