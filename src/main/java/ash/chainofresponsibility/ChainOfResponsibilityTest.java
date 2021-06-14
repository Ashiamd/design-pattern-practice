package ash.chainofresponsibility;

/**
 * 责任链模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 11:33 PM
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Chain oddChain = new OddChain();
        Chain evenChain = new EvenChain();
        Chain bigThanTenChain = new BigThanTenChain();
        oddChain.setNextChain(evenChain);
        evenChain.setNextChain(bigThanTenChain);
        oddChain.work(12346);
        oddChain.work(123);
        oddChain.work(8);
        oddChain.work(7);
    }
}
abstract class Chain{
    protected Chain nextChain;
    protected void setNextChain(Chain nextChain){this.nextChain = nextChain; }
    protected void work(Integer input){
        handle(input);
        if(null != nextChain){
            nextChain.work(input);
        }
    }
    abstract protected void handle(Integer input);
}
class OddChain extends Chain{
    @Override
    protected void handle(Integer input) {
        if((input&1) == 1){
            System.out.println(input + " is odd number");
        }
    }
}
class EvenChain extends Chain{
    @Override
    protected void handle(Integer input) {
        if((input&1) == 0){
            System.out.println(input + " is even number");
        }
    }
}
class BigThanTenChain extends Chain{
    @Override
    protected void handle(Integer input) {
        if(input>10){
            System.out.println(input + " is big than 10");
        }
    }
}
//12346 is even number
//12346 is big than 10
//123 is odd number
//123 is big than 10
//8 is even number
//7 is odd number