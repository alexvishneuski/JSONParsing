package com.github.alexvishneuski.jsonparsing.json.parser.jsonparserimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.json.model.jsonimpl.UserJSONWrapper;
import com.github.alexvishneuski.jsonparsing.json.model.jsonimpl.UsersListJSON;
import com.github.alexvishneuski.jsonparsing.json.parser.IUserListParser;
import com.github.alexvishneuski.jsonparsing.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UsersListJsonObjectParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UsersListJsonObjectParser(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {


        //Reader reader = new InputStreamReader(mIntputStream);
        JSONArray jsonArray = new JSONArray(IOUtils.toString(mIntputStream));

        System.out.println(jsonArray);

        List<IUser> iUsers = new ArrayList<>();
        UserJSONWrapper user;
        for (int n = 0; n < jsonArray.length(); n++) {
            JSONObject userJSON = jsonArray.getJSONObject(n);
            System.out.println(userJSON);

            user = new UserJSONWrapper(userJSON);
            iUsers.add(user);

        }

        return new UsersListJSON(iUsers);
    }
}
