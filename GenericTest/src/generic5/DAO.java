package generic5;

import java.util.*;

/**
 * 定义一个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
 * 分别创建以下方法：
 * public void save(String id,T entity)---保存T类型的对象到Map成员变量中
 * public T get(String id)----从Map中获取id对对应的对象
 * public void update(String id,T entity)----替换map中key为id的内容，改为entity对象
 * public List<T> list()-----返回map中存放的所有T对象
 * public void delete(String id)----删除指定的id对象
 * @author zhaomin
 * @date 2020/2/12 17:18
 */
public class DAO<T> {
    private Map<String,T> map=new HashMap<>();
    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从Map中获取id对对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中key为id的内容，改为entity对象
    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id, entity);
        }

    }
    //返回map中存放的所有T对象
    public List<T> list(){
        //错误写法
       // Collection<T> values = map.values();
        Collection<T> values = map.values();
        List<T> list=new ArrayList<>();
       // list.addAll(values);
        for (T val : values) {
            list.add(val);
        }
        return list;
    }
    //删除指定的id对象
    public void delete(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
