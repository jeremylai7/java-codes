package factory;

import factory.model.Circle;
import factory.model.Rectangle;
import factory.model.Shape;
import factory.model.Square;

/**
 * 创建一个接口和实现类，然后创建一个工厂方法，根据名称返回不同的实例
 */

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
