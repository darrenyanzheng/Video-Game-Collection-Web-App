package com.example.demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class videoGame {
    private String name;
    private String publisher;
    private String platform;
    private String beaten;
    private String dateBought;
    private int id;

    public videoGame(String name, String platform, String publisher, String beaten, String dateBought ) {

        this.name = name;
        this.platform = platform;
        this.publisher = publisher;
        this.beaten = beaten;
        this.dateBought = dateBought;
    }

    public videoGame(int id, String name, String platform, String publisher, String beaten, String dateBought) {

        this.id = id;
        this.name = name;
        this.platform = platform;
        this.publisher = publisher;
        this.beaten = beaten;
        this.dateBought = dateBought;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBeaten() {
        return beaten;
    }

    public void setBeaten(String beaten) {
        this.beaten = beaten;
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id ) {

        this.id = id;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", platform='" + platform + '\'' +
                ", beaten='" + beaten + '\'' +
                ", dateBought='" + dateBought + '\'' +
                '}';
    }


}
