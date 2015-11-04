package com.bugfree.web.application;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class ApplicationResponse {

    private Application application;

    private List<ColorScheme> schemes;

    private List<String> fonts;

    private Shape[] shapes = Shape.values();

    public ApplicationResponse(Application application, List<ColorScheme> schemes) {
        this.application = application;
        this.schemes = schemes;
        this.fonts = asList(Font.values()).stream().map(Font::getName).collect(toList());
    }

    public Application getApplication() {
        return application;
    }

    public List<ColorScheme> getSchemes() {
        return schemes;
    }

    public List<String> getFonts() {
        return fonts;
    }

    public Shape[] getShapes() {
        return shapes;
    }
}
