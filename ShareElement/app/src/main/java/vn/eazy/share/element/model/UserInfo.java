package vn.eazy.share.element.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Harry on 12/9/16.
 */

public class UserInfo implements Serializable {
    private String name;
    private String avatar;
    private String company;
    private String jobPosition;
    private String cover;
    private List<String> galleryUrls;

    public UserInfo(String name, String avatar, String company, String jobPosition, String cover, List<String> galleryUrls) {
        this.name = name;
        this.avatar = avatar;
        this.company = company;
        this.jobPosition = jobPosition;
        this.cover = cover;
        this.galleryUrls = galleryUrls;
    }

    public List<String> getGalleryUrls() {
        return galleryUrls;
    }

    public void setGalleryUrls(List<String> galleryUrls) {
        this.galleryUrls = galleryUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
