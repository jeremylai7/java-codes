package abstractfactory;

public class ColorFactory extends AbstractFactory{


    @Override
    public Color getColor(String colorTye) {
        if (colorTye.equalsIgnoreCase("RED")){
            return new Red();
        }else if (colorTye.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if (colorTye.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
