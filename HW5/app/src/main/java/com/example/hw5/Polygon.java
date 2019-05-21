package com.example.hw5;

import android.content.Context;

public class Polygon {

    private int sides;
    private int sideLength;
    private int degrees;
    private String units;
    private int perimeter;

    public Polygon(int sides, int sideLength, String units) {
        this.sides = sides;
        this.sideLength = sideLength;
        this.units = units;
        this.degrees = (sides - 2) * 180 / sides;
        this.perimeter = sides * sideLength;
    }

    public Polygon(Context context){
        this.sides = Integer.parseInt(context.getString(R.string.default_sides));
        this.sideLength = Integer.parseInt(context.getString(R.string.default_sideLength));
        this.units = context.getString(R.string.default_units);
        this.degrees = (sides - 2) * 180 / sides;
        this.perimeter = sides * sideLength;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public int changeSides(int numSides){
        if(numSides < 3 ){
            sides = 3;

        }else{
            sides = numSides;
        }

        degrees = (sides - 2) * 180 / sides;

        return degrees;
    }

    public int changeLength( int length, String measure){

        if(length < 1){
            sideLength = 1;
        }else{
            sideLength = length;
        }

        units = measure;
        perimeter = sides * sideLength;

        return perimeter;
    }


}
