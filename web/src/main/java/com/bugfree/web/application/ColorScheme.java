package com.bugfree.web.application;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ColorScheme {

    @Id
    private String id;

    private String langCode;

    private String sectionLangCode;

    private String[] colors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String getSectionLangCode() {
        return sectionLangCode;
    }

    public void setSectionLangCode(String sectionLangCode) {
        this.sectionLangCode = sectionLangCode;
    }
}
