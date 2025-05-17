package com.themrsung.core;

public class Quaternion extends AbstractVector4D {
    public Quaternion(double w, double x, double y, double z) {
        super(w, x, y, z);
    }

    public Quaternion(double s, Vector3 v) {
        super(s, v.x, v.y, v.z);
    }

    public Quaternion conjugate() {
        return new Quaternion(w, -x, -y, -z);
    }

    public Quaternion multiply(Vector3 v) {
        double w_ = -x * v.x - y * v.y - z * v.z;
        double x_ =  w * v.x + y * v.z - z * v.y;
        double y_ =  w * v.y + z * v.x - x * v.z;
        double z_ =  w * v.z + x * v.y - y * v.x;
        return new Quaternion(w_, x_, y_, z_);
    }

    public Quaternion multiply(Quaternion q) {
        double w_ = w * q.w - x * q.x - y * q.y - z * q.z;
        double x_ = w * q.x + x * q.w + y * q.z - z * q.y;
        double y_ = w * q.y - x * q.z + y * q.w + z * q.x;
        double z_ = w * q.z + x * q.y - y * q.x + z * q.w;
        return new Quaternion(w_, x_, y_, z_);
    }
}
