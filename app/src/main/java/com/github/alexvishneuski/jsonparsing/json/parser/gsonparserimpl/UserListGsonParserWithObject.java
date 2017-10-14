package com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UsersListWithObjectGson;
import com.github.alexvishneuski.jsonparsing.json.parser.IUserListParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UserListGsonParserWithObject implements IUserListParser {

    private final InputStream mIntputStream;

    public UserListGsonParserWithObject(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        Reader reader = new InputStreamReader(mIntputStream);
        //return new Gson().fromJson(reader, UsersListWithObjectGson.class);

        return new Gson().fromJson(reader, UsersListWithObjectGson.class);



    }
}
