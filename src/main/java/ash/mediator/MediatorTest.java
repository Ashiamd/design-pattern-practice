package ash.mediator;

/**
 * 中介者模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/14 2:40 PM
 */
public class MediatorTest {
    public static void main(String[] args) {
        new Netizen().search("ashiamd", new Chrome());
    }
}
interface Browser{
    void search(String keywords);
}
class Chrome implements Browser{
    @Override
    public void search(String keywords) {
        System.out.println("search by keywords : " + keywords);
    }
}
class Netizen{
    public void search(String keywords, Browser browser){
        browser.search(keywords);
    }
}