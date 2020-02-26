package com.example.preconditions;

import com.google.common.base.Preconditions;
import org.checkerframework.checker.units.qual.C;

public class Circle {
    private final double radius;

    private Circle(double radius){
        Preconditions.checkArgument(radius >= 0, "Invalid radius: %s", radius );
        this.radius = radius;
    }

    public static Circle withRadius(double radius){
        return new Circle(radius);
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircuit() {
        return 2 * radius * Math.PI;
    }
}
