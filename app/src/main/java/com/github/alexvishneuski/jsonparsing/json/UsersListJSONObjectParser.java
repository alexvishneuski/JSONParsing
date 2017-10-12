package com.github.alexvishneuski.jsonparsing.json;

import com.github.alexvishneuski.jsonparsing.utils.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UsersListJSONObjectParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UsersListJSONObjectParser(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {


        //Reader reader = new InputStreamReader(mIntputStream);
        JSONArray jsonArray = new JSONArray(IOUtils.toString(mIntputStream));
                //new JSONObject(IOUtils.toString(mIntputStream)).getJSONArray(null);
        System.out.println(jsonArray);
        //for (JSONArray j:jsonArray) {

        for(int n = 0; n < jsonArray.length(); n++)
        {
            JSONObject user = jsonArray.getJSONObject(n);
            // do some stuff....
            System.out.println(user);
        }
//wrap to GSON???





      //  return new UserJSONWrapper(jsonArray.getJSONObject(0));
     //   UserJSONWrapper[] result = (UserJSONWrapper)jsonArray.getJSONObject(0);
      //  System.out.println(jsonArray.get(0).toString());
        //UserJSONWrapper[] result = new Gson().fromJson(reader, UserGson[].class);
       // return new UsersListGson(Arrays.asList(result));
        return null;
    }
}
