package com.github.alexvishneuski.jsonparsing.json.model.jsonimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;

import org.json.JSONObject;

public class UserJSONWrapper implements IUser {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AVATAR = "avatar";

    private final JSONObject mJsonObject;

    public UserJSONWrapper(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public long getId() {
        return mJsonObject.optLong(ID);
    }

    @Override
    public String getName() {
        return mJsonObject.optString(NAME);
    }

    @Override
    public String getAvatar() {
        return mJsonObject.optString(AVATAR);
    }
}
