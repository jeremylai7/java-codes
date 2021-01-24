package abstractfactory;

/**
 * 工厂生成器
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryType){
        if (factoryType.equalsIgnoreCase("Shape")){
            return new ShapeFactory();
        }else if (factoryType.equalsIgnoreCase("Color")) {
            return new ColorFactory();
        }
        return null;
    }
}
