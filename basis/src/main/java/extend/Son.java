package extend;

/**
 * @author: laizc
 * @date: created in 2022/6/16
 * @desc: 子类覆盖 Override 父类方法，就不会执行父类的方法。
 **/
public class Son extends Parent{

    @Override
    public void print() {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.print();
    }

}
