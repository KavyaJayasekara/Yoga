package com.example.yoga;

public class ModelClass {
    int photo;
    String topic, btn;

    public ModelClass(int photo, String topic, String btn) {
        this.photo = photo;
        this.topic = topic;
        this.btn = btn;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }


}



