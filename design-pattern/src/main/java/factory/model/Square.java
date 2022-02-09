package factory.model;

import factory.Shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("this is Square draw()");
    }
}
