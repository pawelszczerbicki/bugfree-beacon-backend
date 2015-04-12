package com.bugfree.template;

/**
 * Created by pawel on 12.04.15.
 */
public class Template {

    private TemplateType type;

    private String titleColor;

    private String subtitleColor;

    private String contentColor;

    private String backgroundColor;

    public TemplateType getType() {
        return type;
    }

    public void setType(TemplateType type) {
        this.type = type;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getSubtitleColor() {
        return subtitleColor;
    }

    public void setSubtitleColor(String subtitleColor) {
        this.subtitleColor = subtitleColor;
    }

    public String getContentColor() {
        return contentColor;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
