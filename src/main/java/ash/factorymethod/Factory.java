package ash.factorymethod;

/**
 * 工厂方法模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/5/29 8:46 PM
 */
public abstract class Factory {
    abstract Product createProduct(String productName);
}

class AFactory extends Factory{
    @Override
    Product createProduct(String productName) {
        return new Product("AFactory - "+productName);
    }
}

class BFactory extends Factory{
    @Override
    Product createProduct(String productName) {
        return new Product("BFactory - "+productName);
    }
}

class Product {
    String name;
    public Product(String name) { this.name = name; }
    @Override
    public String toString() { return "Product{" + "name='" + name + '\'' +'}'; }
}

class Test{
    public static void main(String[] args) {
        Factory factoryA = new AFactory();
        Factory factoryB = new BFactory();
        Product productA = factoryA.createProduct("hamburger");
        Product productB = factoryB.createProduct("cola");
        System.out.println(productA);
        System.out.println(productB);
    }
}