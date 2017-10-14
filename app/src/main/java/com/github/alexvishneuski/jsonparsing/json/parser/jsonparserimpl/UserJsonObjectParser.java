package com.github.alexvishneuski.jsonparsing.json.parser.jsonparserimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.jsonimpl.UserJSONWrapper;
import com.github.alexvishneuski.jsonparsing.json.parser.IUserParser;

import org.json.JSONObject;

public class UserJsonObjectParser implements IUserParser {

    private final String mSource;

    public UserJsonObjectParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new UserJSONWrapper(jsonObject);
    }

}
