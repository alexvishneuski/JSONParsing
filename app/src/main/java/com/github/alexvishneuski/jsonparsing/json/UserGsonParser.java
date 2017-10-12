package com.github.alexvishneuski.jsonparsing.json;

import com.google.gson.Gson;

class UserGsonParser implements IUserParser {

    private final String mSource;

    UserGsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        return new Gson().fromJson(mSource, UserGson.class);
    }

}
