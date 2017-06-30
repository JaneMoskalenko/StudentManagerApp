package com.example.admin.studentmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.admin.studentmanager.R;
import com.example.admin.studentmanager.utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.example.admin.studentmanager.manager.GroupManager.sGroups;

/**
 * Created by admin on 08.06.2017.
 */

public class Group implements Parcelable{
    private Long id;
    private String groupName;
    private int imageID;

    public Group(String groupName) {
        this.id=System.currentTimeMillis();
        this.groupName = groupName;
    }

    public Group(String groupName, int imageID) {
        this.id = IdGenerator.generateId();
        this.groupName = groupName;
        this.imageID = imageID;
    }

    protected Group(Parcel in) {
        groupName = in.readString();
        imageID = in.readInt();
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

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


/*

    public static ArrayList<Group> getData(String groupName){
        ArrayList<Group> dataList = new ArrayList<>();
        ArrayList<String> GROUPNAMES_FILTERED = new ArrayList<>();
        int [] images =DummyType.getImages();
        Random random = new Random();

        if (groupName.equals("")) {
            for (int i=0; i< DummyType.GROUPNAMES.length; i++) {
                Group group = new Group(("Группа " + DummyType.GROUPNAMES[i]), images[i]);
                dataList.add(group);
            }
        }
        // applying filter
        else {
            for (String grNames:DummyType.GROUPNAMES){
                if (grNames.contains(groupName)){
                    GROUPNAMES_FILTERED.add(grNames);
                }
            }
            if (GROUPNAMES_FILTERED.size()>0)
                for (int i=0; i< GROUPNAMES_FILTERED.size(); i++) {
                    Group group = new Group(("Группа " +  GROUPNAMES_FILTERED.get(i)), images[i]);
                    dataList.add(group);
                }
        }
        return dataList;
    }
*/



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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(groupName);
        dest.writeInt(imageID);
    }
}

