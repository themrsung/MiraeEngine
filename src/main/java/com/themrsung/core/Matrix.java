package com.themrsung.core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.DoubleStream;

public class Matrix implements Iterable<Double> {
    @FunctionalInterface
    public interface MatrixGenerator {
        double generate(int row, int column);
    }

    protected final double[][] values;
    public final int rows, columns;

    public Matrix(int rows, int columns) {
        this.values = new double[rows][columns];

        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(int rows, int columns, MatrixGenerator generator) {
        this(rows, columns);
        fill(generator);
    }

    public double get(int row, int column) {
        return values[row][column];
    }

    public void set(int row, int column, double value) {
        values[row][column] = value;
    }

    public void fill(MatrixGenerator generator) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                values[r][c] = generator.generate(r, c);
            }
        }
    }

    public DoubleStream stream() {
        return Arrays.stream(values).flatMapToDouble(Arrays::stream);
    }

    @Override
    public Iterator<Double> iterator() {
        return stream().iterator();
    }
}
