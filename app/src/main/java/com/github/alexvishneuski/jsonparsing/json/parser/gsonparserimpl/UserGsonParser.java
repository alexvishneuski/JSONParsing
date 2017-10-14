package com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UserGson;
import com.github.alexvishneuski.jsonparsing.json.parser.IUserParser;
import com.google.gson.Gson;

public class UserGsonParser implements IUserParser {

    private final String mSource;

    public UserGsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        return new Gson().fromJson(mSource, UserGson.class);
    }

}
