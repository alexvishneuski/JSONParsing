package com.github.alexvishneuski.jsonparsing.json.parser.parserfactory;

import com.github.alexvishneuski.jsonparsing.json.parser.IUserListParser;
import com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl.UserListGsonParserWithObject;
import com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl.UsersListGsonParser;
import com.github.alexvishneuski.jsonparsing.json.parser.jsonparserimpl.UsersListJsonObjectParser;

import java.io.InputStream;

public class UsersListParserFactory {

    public IUserListParser createGsonParser(InputStream pSource) throws Exception {
        return new UsersListGsonParser(pSource);
    }

    public IUserListParser createParserForResponceWithObject(InputStream pSource) {
        return new UserListGsonParserWithObject(pSource);
    }

    public IUserListParser createParserForResponceWithJSONArray(InputStream pSource) {
        return new UsersListJsonObjectParser(pSource);
    }
}
