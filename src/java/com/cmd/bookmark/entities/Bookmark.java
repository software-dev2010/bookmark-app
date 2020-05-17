package com.cmd.bookmark.entities;

import com.cmd.bookmark.constants.KidFriendlyStatus;

public abstract class Bookmark {

    private long id;
    private String title;
    private String profile;
    private KidFriendlyStatus kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
    private User kidFriendlyMarkedBy;
    private User shareBy;

    public User getShareBy() {
        return shareBy;
    }

    public void setShareBy(User shareBy) {
        this.shareBy = shareBy;
    }

    public User getKidFriendlyMarkedBy() {
        return kidFriendlyMarkedBy;
    }

    public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
        this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
    }



    public void setKidFriendlyStatus(KidFriendlyStatus kidFriendlyStatus) {
        this.kidFriendlyStatus = kidFriendlyStatus;
    }

    public KidFriendlyStatus getKidFriendlyStatus() {
        return kidFriendlyStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public abstract boolean isKidFriendlyEligible();
}
