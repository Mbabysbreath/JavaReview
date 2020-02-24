package reflection3;

import java.io.Serializable;

/**
 * @author zhaomin
 * @date 2020/2/21 23:35
 */
public class Creature<T>implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }


}
