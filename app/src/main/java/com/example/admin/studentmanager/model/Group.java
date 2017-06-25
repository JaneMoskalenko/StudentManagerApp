package com.example.admin.studentmanager.model;

import com.example.admin.studentmanager.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.sGroups;

/**
 * Created by admin on 08.06.2017.
 */

public class Group {
    private Long id;
    private String groupName;
    private int imageID;

    public Group(String groupName) {
        this.id=System.currentTimeMillis();
        this.groupName = groupName;
    }

    public Group(String groupName, int imageID) {
        this.id=System.currentTimeMillis();
        this.groupName = groupName;
        this.imageID=imageID;
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public static ArrayList<Group> getData(){
        ArrayList<Group> dataList = new ArrayList<>();
        int [] images =DummyType.getImages();
        Random random = new Random();


        for (int i=0; i< DummyType.GROUPNAMES.length; i++) {
            Group group = new Group(("Группа " + DummyType.GROUPNAMES[i]), images[i]);
            dataList.add(group);
        }
        return dataList;
    }



    @Override
    public int hashCode() {
        return (21+groupName.hashCode()*41)+(21+id.hashCode()*41);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Group)) return false;
        if (this.id != ((Group) obj).getId()) return false;
        return true;
    }

}

