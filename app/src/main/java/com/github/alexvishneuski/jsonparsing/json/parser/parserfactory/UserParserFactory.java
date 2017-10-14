package com.github.alexvishneuski.jsonparsing.json.parser.parserfactory;

import com.github.alexvishneuski.jsonparsing.json.parser.IUserParser;
import com.github.alexvishneuski.jsonparsing.json.parser.gsonparserimpl.UserGsonParser;
import com.github.alexvishneuski.jsonparsing.json.parser.jsonparserimpl.UserJsonObjectParser;


public class UserParserFactory {


    public IUserParser createJsonParser(String pSource) {
        return new UserJsonObjectParser(pSource);
    }
    public IUserParser createGsonParser(String pSource) {
        return new UserGsonParser(pSource);
    }

}
