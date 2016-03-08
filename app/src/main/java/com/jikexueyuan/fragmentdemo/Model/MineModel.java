package com.jikexueyuan.fragmentdemo.Model;

/**
 * Created by bowenzhang on 16/3/3.
 */

/*
* MineModel include photoID and ID corresponding event
* */
public class MineModel {

    private int photoID;
    private String label;

    public MineModel(int photoID, String label) {
        this.photoID = photoID;
        this.label = label;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getLabel() {
        return label;
    }

}
