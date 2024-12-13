package ru.appline.logic;

public class Compass {
    private String north;
    private String east;
    private String south;
    private String west;
    private String northEast;
    private String northWest;
    private String southWest;
    private String southEast;

    public Compass() {
        super();
    }

    public Compass(String North, String East, String South, String West, String NorthEast, String NorthWest, String SouthWest, String SouthEast) {
        this.north = North;
        this.east = East;
        this.south = South;
        this.west = West;
        this.northEast = NorthEast;
        this.northWest = NorthWest;
        this.southWest = SouthWest;
        this.southEast = SouthEast;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getNorthEast() {
        return northEast;
    }

    public void setNorthEast(String northEast) {
        this.northEast = northEast;
    }

    public String getNorthWest() {
        return northWest;
    }

    public void setNorthWest(String northWest) {
        this.northWest = northWest;
    }

    public String getSouthWest() {
        return southWest;
    }

    public void setSouthWest(String southWest) {
        this.southWest = southWest;
    }

    public String getSouthEast() {
        return southEast;
    }

    public void setSouthEast(String southEast) {
        this.southEast = southEast;
    }
}
