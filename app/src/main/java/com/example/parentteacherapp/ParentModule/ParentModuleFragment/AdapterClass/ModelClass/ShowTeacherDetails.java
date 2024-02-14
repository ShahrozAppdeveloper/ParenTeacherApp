package com.example.parentteacherapp.ParentModule.ParentModuleFragment.AdapterClass.ModelClass;

public class ShowTeacherDetails {
    String teacherID,teachername,teacher,teacherdepartment,teacherImage;

    public ShowTeacherDetails(String teacherID, String teachername, String teacher, String teacherdepartment, String teacherImage) {
        this.teacherID = teacherID;
        this.teachername = teachername;
        this.teacher = teacher;
        this.teacherdepartment = teacherdepartment;
        this.teacherImage = teacherImage;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacherdepartment() {
        return teacherdepartment;
    }

    public void setTeacherdepartment(String teacherdepartment) {
        this.teacherdepartment = teacherdepartment;
    }

    public String getTeacherImage() {
        return teacherImage;
    }

    public void setTeacherImage(String teacherImage) {
        this.teacherImage = teacherImage;
    }
}
