package ash.interpreter;

import java.util.HashMap;

/**
 * 解释器模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 4:05 PM
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.saveVar("a", 1);
        context.saveVar("b", 2);
        context.saveVar("c", 3);
        VarExpression a = new VarExpression("a");
        VarExpression b = new VarExpression("b");
        VarExpression c = new VarExpression("c");
        Expression aPlusB = new PlusExpression(a,b);
        System.out.println(aPlusB.interpret(context));
        Expression aPlusBMinusC = new MinusExpression(aPlusB,c);
        System.out.println(aPlusBMinusC.interpret(context));
    }
}

class Context{
    private HashMap<String,Integer> vars = new HashMap<>();
    public Integer getVar(String var){ return vars.get(var); }
    public void saveVar(String var, Integer val){vars.put(var,val);}
}
interface Expression{
    Integer interpret(Context context);
}
class VarExpression implements Expression{
    String var;
    public VarExpression(String var) { this.var = var; }
    @Override
    public Integer interpret(Context context) { return context.getVar(this.var); }
}
class PlusExpression implements Expression{
    Expression a;
    Expression b;
    public PlusExpression(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer interpret(Context context) {
        return a.interpret(context) + b.interpret(context);
    }
}
class MinusExpression implements Expression{
    Expression a;
    Expression b;
    public MinusExpression(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public Integer interpret(Context context) {
        return a.interpret(context) - b.interpret(context);
    }
}
//3
//0