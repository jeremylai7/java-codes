package factory;

import factory.model.Shape;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-25
 * @desc:
 */
public abstract class AbstractShapeFactory2 {

	public abstract <T extends Shape>T getShape(Class<T> tClass);

}
