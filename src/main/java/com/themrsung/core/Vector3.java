package com.themrsung.core;

import java.util.Iterator;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class Vector3 implements Iterable<Double> {
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    public final double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    public double volume() {
        return x * y * z;
    }

    public Vector3 add(Vector3 v) {
        return new Vector3(
                x + v.x,
                y + v.y,
                z + v.z
        );
    }

    public Vector3 subtract(Vector3 v) {
        return new Vector3(
                x - v.x,
                y - v.y,
                z - v.z
        );
    }

    public Vector3 multiply(double s) {
        return new Vector3(x * s, y * s, z * s);
    }

    public Vector3 divide(double s) throws ArithmeticException {
        return new Vector3(x / s, y / s, z / s);
    }

    public Vector3 rotate(Quaternion q) {
        Quaternion p = new Quaternion(0, this);
        Quaternion qConj = p.conjugate();
        Quaternion rotated = q.multiply(p).multiply(qConj);
        return new Vector3(rotated.x, rotated.y, rotated.z);
    }

    public double dot(Vector3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3 cross(Vector3 v) {
        return new Vector3(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x
        );
    }

    public Vector3 abs() {
        return new Vector3(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    public Vector3 negate() {
        return new Vector3(-x, -y, -z);
    }

    public Vector3 normalize() {
        try {
            return divide(length());
        } catch (ArithmeticException e) {
            return ZERO;
        }
    }

    public Vector3 map(DoubleUnaryOperator mapper) {
        return new Vector3(
                mapper.applyAsDouble(x),
                mapper.applyAsDouble(y),
                mapper.applyAsDouble(z)
        );
    }

    public DoubleStream stream() {
        return DoubleStream.of(x, y, z);
    }

    @Override
    public Iterator<Double> iterator() {
        return stream().iterator();
    }
}