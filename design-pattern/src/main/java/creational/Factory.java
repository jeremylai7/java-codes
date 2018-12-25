package creational;

/**
 * @Author: laizc
 * @Date: Created in 17:26 2018-12-25
 * @工厂模式
 */
//1、创建一个接口
interface Shape {
    void draw();
}
//2、创建接口实体类
class  Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("this is Rectangle draw()");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("this is Square draw()");
    }
}
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
//3 、创建一个工厂类
class ShapeFactory {
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
}
public class Factory{
    // 4、通过使用工厂，传递不同参数来获取不同实体类的对象
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

    }

}
