package com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass;

public class AssignmentModelCass {
    String homeworktext,textcount;
    int icon;

    public AssignmentModelCass(String homeworktext, String textcount, int icon) {
        this.homeworktext = homeworktext;
        this.textcount = textcount;
        this.icon = icon;
    }

    public String getHomeworktext() {
        return homeworktext;
    }

    public void setHomeworktext(String homeworktext) {
        this.homeworktext = homeworktext;
    }

    public String getTextcount() {
        return textcount;
    }

    public void setTextcount(String textcount) {
        this.textcount = textcount;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
