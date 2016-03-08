package com.jikexueyuan.fragmentdemo.Model;

/**
 * Created by bowenzhang on 16/3/3.
 */

/*
* HomepageModel includes the all the information which you need.
* */
public class HomepageModel {
    private int photoID;
    private String name;
    private int startValue;
    private int deliverFee;
    private int sellNumber;
    private String review;

    public HomepageModel(int photoID, String name, int startValue, int deliverFee, int sellNumber, String review) {
        this.photoID = photoID;
        this.name = name;
        this.startValue = startValue;
        this.deliverFee = deliverFee;
        this.sellNumber = sellNumber;
        this.review = review;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getName() {
        return name;
    }

    public int getStartValue() {
        return startValue;
    }

    public int getDeliverFee() {
        return deliverFee;
    }

    public int getSellNumber() {
        return sellNumber;
    }

    public String getReview() {
        return review;
    }
}
