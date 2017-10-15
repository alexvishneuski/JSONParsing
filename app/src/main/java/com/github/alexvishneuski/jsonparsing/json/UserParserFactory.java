package com.github.alexvishneuski.jsonparsing.json;

public class UserParserFactory {


    public IUserParser createParser(String pSource) {
        return new UserJSONObjectParser(pSource);
    }

}
