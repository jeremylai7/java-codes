package strategy;

public class OperationDivide implements Strategy{
    @Override
    public int doOperation(int a, int b) {
        return a/b;
    }
}
