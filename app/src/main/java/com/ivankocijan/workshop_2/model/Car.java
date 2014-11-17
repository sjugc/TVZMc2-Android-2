package com.ivankocijan.workshop_2.model;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 17.11.14.
 */
public class Car {

    private String name;
    private int imageId;

    public Car (String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName () {
        return name;
    }

    public int getImageId () {
        return imageId;
    }
}
