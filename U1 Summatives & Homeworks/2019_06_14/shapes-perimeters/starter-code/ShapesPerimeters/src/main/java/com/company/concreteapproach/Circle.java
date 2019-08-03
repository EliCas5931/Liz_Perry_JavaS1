package com.company.concreteapproach;

public class Circle extends Shape {

    private double radius;

    public double area() {

        double area = Math.PI * radius * radius;

        return area;

    }

    public double perimeter() {

        double perimeter = 2 * Math.PI * radius;

        return perimeter;

    }


}
