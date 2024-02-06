package com.example.parentteacherapp.ModelCLass;

public class CurrentStatusDetails {
    String userID,username,userpassword,useremail,currentstatus;

    public CurrentStatusDetails(String userID, String username, String userpassword, String useremail, String currentstatus) {
        this.userID = userID;
        this.username = username;
        this.userpassword = userpassword;
        this.useremail = useremail;
        this.currentstatus = currentstatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getCurrentstatus() {
        return currentstatus;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }
}
