package com.github.alexvishneuski.jsonparsing.json;

import com.github.alexvishneuski.jsonparsing.BuildConfig;
import com.github.alexvishneuski.jsonparsing.http.IHttpClient;
import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;
import com.github.alexvishneuski.jsonparsing.json.parser.parserfactory.UserParserFactory;
import com.github.alexvishneuski.jsonparsing.json.parser.parserfactory.UsersListParserFactory;
import com.github.alexvishneuski.jsonparsing.mocks.Mocks;
import com.github.alexvishneuski.jsonparsing.utils.Constants;
import com.github.alexvishneuski.jsonparsing.utils.IOUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class UserParserTest {

    private static final String TAG = UserParserTest.class.getSimpleName();

    private static final String SOURCE = "{\n" +
            "  \"id\" : 1,\n" +
            "  \"name\" : \"First Name and Last Name\",\n" +
            "  \"avatar\" : \"http://placehold.it/32x32\"\n" +
            "}";

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final String EXPECTED_AVATAR = "http://placehold.it/32x32";
    //classMember initialization
    private IHttpClient mHttpClient;

    private UserParserFactory userParserFactory;
    private UsersListParserFactory usersListParserFactory;

    @Before
    //interfaceMocking
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
        userParserFactory = new UserParserFactory();
        usersListParserFactory = new UsersListParserFactory();
    }

    @Test
    public void parse() throws Exception {

        final IUser user = userParserFactory.createJsonParser(SOURCE).parse();

        assertEquals(EXPECTED_ID, user.getId());
        assertEquals(EXPECTED_NAME, user.getName());
        assertEquals(EXPECTED_AVATAR, user.getAvatar());
    }

    @Test
    public void parseUserListFromResource() throws Exception {
        InputStream mockedInputStream = Mocks.stream("user/user_list.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getUserList");

       // final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        final IUsersList userList = usersListParserFactory.createGsonParser(response).parse();
        assertTrue(userList.getUsersList().size() == 2);
        assertTrue(userList.getUsersList().get(0).getId() == 1);
        assertEquals(userList.getUsersList().get(0).getName(), "First Name and Last Name");


        InputStream mockedInputStreamWithObject = Mocks.stream("user/user_list_with_root_object.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStreamWithObject);
        InputStream responseWithObject = mHttpClient.request("http://myBackend/getUserListWithObject");

        final IUsersList userListWithObject = usersListParserFactory.createParserForResponceWithObject(responseWithObject).parse();
        assertTrue(userListWithObject.getUsersList().size() == 2);


    }

    //HOME WORK AREA
    @Test
    public void parseJsonObjectHW() throws Exception {
        //prepared response with jsonObject
        InputStream mockedInputStream = Mocks.stream("user/homework_json_object_preparing.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getAliaksandrInfo");

        //parsed response over JSONObject
       // final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createJsonParser(IOUtils.toString(response)).parse();


        assertEquals(99, user.getId());
        assertEquals("Aliaksandr Vishneuski", user.getName());
        assertEquals("http://vk.com/dscfd/dsf/.../32.jpg", user.getAvatar());
    }

    @Test
    public void parseJsonArrayHW() throws Exception {
        //prepared response with jsonArray
        InputStream mockedInputStream = Mocks.stream("user/homework_json_array_preparing.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getFamilyInfo");

        //parsed response over JSONArray
        //final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        final IUsersList userList = usersListParserFactory.createParserForResponceWithJSONArray(response).parse();
        assertTrue(userList.getUsersList().size() == 3);
        assertTrue(userList.getUsersList().get(0).getId() == 99);
        assertEquals(userList.getUsersList().get(0).getName(), "Aliaksandr Vishneuski");
    }

    @Test
    public void parseGsonbjectHW() throws Exception {
        //prepared response with jsonObject
        InputStream mockedInputStream = Mocks.stream("user/homework_json_object_preparing.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getAliaksandrInfo");

        //parsed response over Gson
       // final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createGsonParser(IOUtils.toString(response)).parse();

        assertEquals(99, user.getId());
        assertEquals("Aliaksandr Vishneuski", user.getName());
        assertEquals("http://vk.com/dscfd/dsf/.../32.jpg", user.getAvatar());
    }

    @Test
    public void parseArrayOverGsonHW() throws Exception {
        //prepared response with jsonArray
        InputStream mockedInputStream = Mocks.stream("user/homework_json_array_preparing.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getFamilyInfo");

        //parsed response over Gson
      //  final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        final IUsersList userList = usersListParserFactory.createParserForResponceWithJSONArray(response).parse();
        assertTrue(userList.getUsersList().size() == 3);
        assertTrue(userList.getUsersList().get(0).getId() == 99);
        assertEquals(userList.getUsersList().get(0).getName(), "Aliaksandr Vishneuski");
    }

    public static class test {
    }
}