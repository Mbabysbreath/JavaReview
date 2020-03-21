package exception20200115;

/**
 * 自定义异常
 * 1.继承现有的异常体系结构RuntimeException,Exception
 * 2.提供序列版本号
 * 3.提供重载的构造器
 * @author zhaomin
 * @date 2020/1/15 20:17
 */
public class EcDef extends Exception {
    static final long serialVersionUID = -33875169124229948L;
    public EcDef(){

    }
    public EcDef(String msg){
        super(msg);
    }
}

