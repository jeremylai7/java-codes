package creational;

import javax.xml.stream.FactoryConfigurationError;

public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape = factory.getShape("Circle");
        shape.draw();

        shape = factory.getShape("Rectangle");
        shape.draw();
    }


}
