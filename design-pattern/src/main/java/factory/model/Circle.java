package factory.model;

import factory.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("this is circle draw()");
    }
}
