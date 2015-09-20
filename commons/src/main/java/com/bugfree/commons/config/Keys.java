package com.bugfree.commons.config;

/**
 * Created by Pawel on 2014-07-23.
 */
public class Keys {
    public static final String PHOTOS_BUCKET = "amazon.s3.photo";
    public static final String LOGO_BUCKET = "amazon.s3.logo";
    public static final String S3_ENABLED = "amazon.s3.enabled";
    public static final String MONGO_HOST = "MONGO_HOST";
    public static final String MONGO_PORT = "MONGO_PORT";
    public static final String MONGO_DATABASE = "MONGO_DATABASE";
    public static final String MONGO_USERNAME = "MONGO_USERNAME";
    public static final String MONGO_PASSWORD = "MONGO_PASSWORD";

    public static final String BEACON_NOT_PRESENT = "Beacon with requested id is not present";
    public static final String UPLOAD_ERROR = "Error occurred during photo upload";
    public static final String NOT_FOUND = "Requested resource was not found";
    public static final String INTERNAL_SERVER_ERROR = "Some error occurred. Code [%s], Message [%s]";
}
