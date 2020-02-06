package compare;

/**
 * 商品类
 * @author zhaomin
 * @date 2020/2/4 19:05
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(){

    }
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * 指明商品比较大小的方式
     * （1）按照价格从低到高
    * （2）再按照产品名称从低到高
     * @param o 对象
     * @return 返回比较的值
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods) {
            Goods goods = (Goods) o;

            //方式一：
            if (this.price >goods.price) {
                return 1;
            }else if(this.price<goods.price){
                return -1;
            }else{
                //return 0;
                return this.name.compareTo(goods.name);
            }
            //方式二：
            //return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
