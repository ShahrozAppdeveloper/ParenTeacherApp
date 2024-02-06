package com.example.parentteacherapp.ModelCLass;

public class AddTeacherDetailToRealtym {
    String userID,name,schoolid,department,imageurl;

    public AddTeacherDetailToRealtym() {
    }

    public AddTeacherDetailToRealtym(String userID, String name, String schoolid, String department, String imageurl) {
        this.userID = userID;
        this.name = name;
        this.schoolid = schoolid;
        this.department = department;
        this.imageurl = imageurl;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
