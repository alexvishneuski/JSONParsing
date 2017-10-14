package com.github.alexvishneuski.jsonparsing.json.model.jsonimpl;

import com.github.alexvishneuski.jsonparsing.json.model.IUser;
import com.github.alexvishneuski.jsonparsing.json.model.IUsersList;

import java.util.List;

public class UsersListJSON implements IUsersList {

    private List<IUser> mUsersLists;

    public UsersListJSON(List<IUser> mUsersLists) {
        this.mUsersLists = mUsersLists;
    }

    @Override
    public List<IUser> getUsersList() {
        return mUsersLists;
    }
}
