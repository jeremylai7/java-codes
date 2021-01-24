package strategy;

/**
 * 策略模式
 * 先定义一个strategy接口和strategy实现类，然后使用context来决定使用哪种策略
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int operation(int a,int b){
        return strategy.doOperation(a, b);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        Context context = new Context(new OperationAdd());
        int result = context.operation(a,b);
        System.out.println("a+b=" + result);

        context = new Context(new OperationSubstract());
        result = context.operation(a,b);
        System.out.println("a-b=" + result);

        context = new Context(new OperationMultiply());
        result = context.operation(a,b);
        System.out.println("a*b="+result);

    }
}
