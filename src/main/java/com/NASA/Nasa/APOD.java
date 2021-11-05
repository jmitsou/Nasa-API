package com.NASA.Nasa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APOD {

    /*public APOD(String title, String date, String explanation, URL iconURL, ImageIcon icon, Image i) {
        this.title = title;
        this.date = date;
        this.explanation = explanation;
        this.iconURL = iconURL;
        this.icon = icon;
        this.i = i;
    }*/

    private String title;
    private String date;
    private String explanation;

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    private String hdurl;
    private String copyright;

    URL iconURL = new URL("https://apod.nasa.gov/apod/image/2111/NGC147NGC185satellites.jpg");
    // iconURL is null when not found
    ImageIcon icon = new ImageIcon(iconURL);
    Image i = icon.getImage();

    public APOD() throws MalformedURLException {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
