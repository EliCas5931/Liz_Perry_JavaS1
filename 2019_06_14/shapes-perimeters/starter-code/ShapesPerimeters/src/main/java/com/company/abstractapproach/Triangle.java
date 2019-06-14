package com.company.abstractapproach;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public double area() {

        double p = perimeter() / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));

    }

    public double perimeter() {

        return sideA + sideB + sideC;

    }

}
