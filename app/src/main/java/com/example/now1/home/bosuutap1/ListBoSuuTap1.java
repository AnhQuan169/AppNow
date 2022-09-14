package com.example.now1.home.bosuutap1;

public class ListBoSuuTap1 {
    int imagebst,id;
    String namebst;

    public ListBoSuuTap1(int id,int imagebst, String namebst) {
        this.id=id;
        this.imagebst = imagebst;
        this.namebst = namebst;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getImagebst() {
        return imagebst;
    }

    public void setImagebst(int imagebst) {
        this.imagebst = imagebst;
    }

    public String getNamebst() {
        return namebst;
    }

    public void setNamebst(String namebst) {
        this.namebst = namebst;
    }
}
