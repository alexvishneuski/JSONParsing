package com.github.alexvishneuski.jsonparsing.json;

import java.io.InputStream;

public class UsersListParserFactory {

    public IUserListParser createParser(InputStream pSource) throws Exception {
        return new UsersListGSONParser(pSource);
    }

    public IUserListParser createParserForResponceWithObject(InputStream pSource) {
        return new UserListGsonParserWithObject(pSource);
    }

    public IUserListParser createParserForResponceWithJSONArray(InputStream pSource) {
        return new UsersListJSONObjectParser(pSource);
    }
}
