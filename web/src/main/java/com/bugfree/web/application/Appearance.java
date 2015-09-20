package com.bugfree.web.application;

/**
 * Created by pawel on 20.09.15.
 */
public class Appearance {

    private String photoBackgroundColor;

    private String descriptionBackgroundColor;

    private String titleColor;

    private String textColor;

    private Shape photoShape;

    private boolean withUrlButton = true;

    public String getPhotoBackgroundColor() {
        return photoBackgroundColor;
    }

    public void setPhotoBackgroundColor(String photoBackgroundColor) {
        this.photoBackgroundColor = photoBackgroundColor;
    }

    public String getDescriptionBackgroundColor() {
        return descriptionBackgroundColor;
    }

    public void setDescriptionBackgroundColor(String descriptionBackgroundColor) {
        this.descriptionBackgroundColor = descriptionBackgroundColor;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Shape getPhotoShape() {
        return photoShape;
    }

    public void setPhotoShape(Shape photoShape) {
        this.photoShape = photoShape;
    }

    public boolean isWithUrlButton() {
        return withUrlButton;
    }

    public void setWithUrlButton(boolean withUrlButton) {
        this.withUrlButton = withUrlButton;
    }
}
