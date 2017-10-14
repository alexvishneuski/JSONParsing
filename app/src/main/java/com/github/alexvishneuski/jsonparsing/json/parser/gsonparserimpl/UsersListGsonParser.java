package com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UserGson;
import com.github.alexvishneuski.jsonparsing.json.model.gsonimpl.UsersListGson;
import com.github.alexvishneuski.jsonparsing.json.parser.IUserListParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersListGsonParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UsersListGsonParser(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        Reader reader = new InputStreamReader(mIntputStream);
        UserGson[] result = new Gson().fromJson(reader, UserGson[].class);


        List<IUser> iUsers = new ArrayList<>();

        iUsers.addAll(Arrays.asList(result));

        return new UsersListGson(iUsers);

    }
}
