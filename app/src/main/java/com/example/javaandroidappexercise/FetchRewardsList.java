package com.example.javaandroidappexercise;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FetchRewardsList {
    //declare variables from json file
    @SerializedName("id")
    String id;
    @SerializedName("listId")
    String listId;
    @SerializedName("name")
    String name;

    public FetchRewardsList(String id, String listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    //Getter and setter methods
    public String getId() {
        return id;
    }

    public String getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public String setId(String id) {
        return this.id = id;
    }

    public String setListId(String listId) {
        return this.listId = listId;
    }

    public String setName(String name) {
        return this.name = name;
    }
}