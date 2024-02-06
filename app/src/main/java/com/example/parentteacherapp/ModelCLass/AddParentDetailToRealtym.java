package com.example.parentteacherapp.ModelCLass;

public class AddParentDetailToRealtym {
    String userID,name,rollnum,department,imageurl;

    public AddParentDetailToRealtym() {
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

    public String getRollnum() {
        return rollnum;
    }

    public void setRollnum(String rollnum) {
        this.rollnum = rollnum;
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

    public AddParentDetailToRealtym(String userID, String name, String rollnum, String department, String imageurl) {
        this.userID = userID;
        this.name = name;
        this.rollnum = rollnum;
        this.department = department;
        this.imageurl = imageurl;
    }
}
