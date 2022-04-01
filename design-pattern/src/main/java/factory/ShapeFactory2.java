package factory;

import factory.model.Circle;
import factory.model.Rectangle;
import factory.model.Shape;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-25
 * @desc: 创建工厂方法，根据不同的类获取不同的实例
 */
public class ShapeFactory2 extends AbstractShapeFactory2{

	@Override
	public <T extends Shape> T getShape(Class<T> tClass) {
		Shape shape;
		try {
			shape =  (T) Class.forName(tClass.getName()).newInstance();
			return (T) shape;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void main(String[] args) {
		ShapeFactory2 factory = new ShapeFactory2();
		Shape circleShape = factory.getShape(Circle.class);
		circleShape.draw();

		Shape rectangleShape = factory.getShape(Rectangle.class);
		rectangleShape.draw();
	}

}
