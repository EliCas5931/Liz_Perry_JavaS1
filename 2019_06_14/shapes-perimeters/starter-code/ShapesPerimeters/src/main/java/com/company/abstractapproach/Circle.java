package com.company.abstractapproach;

public class Circle extends Shape {

    private double radius;

    public double area() {

        return Math.PI * radius * radius;

    }

    public double perimeter() {

        return 2 * Math.PI * radius;

    }

}
