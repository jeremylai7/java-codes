package abstractfactory;

public class Test {

    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color = colorFactory.getColor("red");
        color.fill();

        color = colorFactory.getColor("blue");
        color.fill();

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape = shapeFactory.getShape("circle");
        shape.draw();

        shape = shapeFactory.getShape("square");
        shape.draw();


    }
}
