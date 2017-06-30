package com.example.admin.studentmanager.manager;

import android.util.Log;

import com.example.admin.studentmanager.model.DummyType;
import com.example.admin.studentmanager.model.Group;
import com.example.admin.studentmanager.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.admin.studentmanager.model.DummyType.getImages;

/**
 * Created by admin on 25.06.2017.
 */

public class GroupManager {
    private static final String TAG = "GroupManager";
    public static HashMap<Long, Group> sGroups = new HashMap<>();
    public static int groupNamesLength = DummyType.GROUPNAMES.length;

    public GroupManager() {
        for (int i = 0; i < groupNamesLength; i++) {
            Group group = createDummyGroup();
            sGroups.put(group.getId(), group);
            Log.d(TAG, " on init Dummy group " + group.getId() + "  " + groupNamesLength);
        }
    }

    public static Group createDummyGroup() {
        Random random = new Random();
        int indexGroup = random.nextInt(groupNamesLength);
        Log.d(TAG, " on create Dummy group " + DummyType.GROUPNAMES[indexGroup] + "  " + groupNamesLength);
        return new Group(DummyType.GROUPNAMES[indexGroup], DummyType.getRandomImage());
    }

    public int getGroupsSize() {
        return sGroups.size();
    }

    public static ArrayList<Group> getGroupsByName(String groupName) {
        ArrayList<Group> dataList = new ArrayList<>();
        Group group;
        for (Map.Entry<Long, Group> entry : sGroups.entrySet()) {
            group = entry.getValue();
            if (group.getGroupName().contains(groupName)) {
                System.out.println(entry.getKey() + " = " + group.getId() + " " + group.getGroupName());
                dataList.add(group);
            }
        }
        return dataList;
    }

    public static String getGroupNameByID(Long GroupID) {
        Group group;
        group = sGroups.get(GroupID);
        return group.getGroupName();
    }

    private static int getRandomNumberOfGroup(){
        Random random = new Random();
        return random.nextInt(groupNamesLength);
    }

    public static Long getRandomGroupID() {
        int i = 0;
        int random = getRandomNumberOfGroup();
        Long ID = 0L;
        for (Map.Entry<Long, Group> entry : sGroups.entrySet()) {
            if (i == random) ID =  entry.getKey();
            i++;
        }
        return ID;
    }

}
