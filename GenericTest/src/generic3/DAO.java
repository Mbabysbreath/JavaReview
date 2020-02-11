package generic3;

import java.util.List;

/**
 * @author zhaomin
 * @date 2020/2/11 22:38
 * DAO---data(base) access object
 * 操作数据库的一系列动作
 */
//操作表的共有操作的DAO
public class DAO<T> {
    //添加一条记录
    public void add(T t){

    }

    //删除一条记录
    public boolean remove(int index) {
        return false;
    }

    //修改一条记录
    public void update(int index,T t) {

    }

    //查询一条记录
    public T getIndex(int index) {
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index) {
        return null;
    }
    //泛型方法
    //举例：获取表中一共有多少条记录--Long
    public <E> E getValue(){
        return null;
    }
}
