package com.themrsung.core;

import java.util.Iterator;
import java.util.stream.DoubleStream;

abstract class AbstractVector4D implements Iterable<Double> {
    public final double w, x, y, z;

    AbstractVector4D(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DoubleStream stream() {
        return DoubleStream.of(w, x, y, z);
    }

    @Override
    public Iterator<Double> iterator() {
        return stream().iterator();
    }
}
