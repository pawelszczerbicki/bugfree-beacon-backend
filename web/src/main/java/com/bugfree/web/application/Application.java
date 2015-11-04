package com.bugfree.web.application;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pawel on 18.08.15.
 */
@Document
public class Application {

    private String splashScreenTitle;

    private String logoUrl;

    private String splashScreenBackground;

    private ArrangeType arrange;

    private Shape photoShape;

    private Appearance appearance = new Appearance();

    public String getSplashScreenTitle() {
        return splashScreenTitle;
    }

    public void setSplashScreenTitle(String splashScreenTitle) {
        this.splashScreenTitle = splashScreenTitle;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSplashScreenBackground() {
        return splashScreenBackground;
    }

    public void setSplashScreenBackground(String splashScreenBackground) {
        this.splashScreenBackground = splashScreenBackground;
    }

    public ArrangeType getArrange() {
        return arrange;
    }

    public void setArrange(ArrangeType arrange) {
        this.arrange = arrange;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Application withShape(Shape s) {
        this.photoShape = s;
        return this;
    }

    public Application withAppearance(Appearance a) {
        setAppearance(a);
        return this;
    }

    public Application withArrangeType(ArrangeType a) {
        setArrange(a);
        return this;
    }
}
