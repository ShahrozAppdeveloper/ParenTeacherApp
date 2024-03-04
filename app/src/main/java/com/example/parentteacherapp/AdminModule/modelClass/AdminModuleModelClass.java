package com.example.parentteacherapp.AdminModule.modelClass;

public class AdminModuleModelClass {
    private int image;
    private String title;
    private int position;

    public AdminModuleModelClass(int image, String title, int position) {
        this.image = image;
        this.title = title;
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
