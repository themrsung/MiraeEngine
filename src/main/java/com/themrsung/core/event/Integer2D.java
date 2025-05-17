package com.themrsung.core.event;

public class Integer2D {
    public int x, y;

    public Integer2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int area() {
        return x * y;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public int lengthSquared() {
        return x * x + y * y;
    }
}
