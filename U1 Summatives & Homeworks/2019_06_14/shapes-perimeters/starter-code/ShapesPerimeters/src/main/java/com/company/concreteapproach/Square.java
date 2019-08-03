package com.company.concreteapproach;

public class Square extends Shape {

    private double side;

    public double area() {

        double area = side * side;

        return area;

    }

    public double perimeter() {

        double perimeter = 4 * side;

        return perimeter;

    }

}
