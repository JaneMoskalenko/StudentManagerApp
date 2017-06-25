package com.example.admin.studentmanager.manager;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Group;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by admin on 25.06.2017.
 */

public class GroupManager {
    public static HashMap<Long, Group> sGroups = new HashMap<>();

    public static void createDummyGroup(Long number) {
        Random random = new Random();
        int indexGroup = random.nextInt(DummyType.GROUPNAMES.length);
        sGroups.put(number, new Group(DummyType.GROUPNAMES[indexGroup]));
    }


}
