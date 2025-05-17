package com.themrsung.core;

import java.util.Iterator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class Vector2 implements Iterable<Double> {
    public final double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return x * x + y * y;
    }

    public double area() {
        return x * y;
    }

    public Vector2 map(DoubleUnaryOperator mapper) {
        return new Vector2(
                mapper.applyAsDouble(x),
                mapper.applyAsDouble(y)
        );
    }

    public DoubleStream stream() {
        return DoubleStream.of(x, y);
    }

    @Override
    public Iterator<Double> iterator() {
        return stream().iterator();
    }
}
