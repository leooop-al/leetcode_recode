package leetcode.top100;

import java.util.*;

/**
 * @author ziyou.cxf
 * @version : LRU.java, v 0.1 2022年04月22日 10:55 ziyou.cxf Exp $
 */
public class LRU {


    private int capacity;

    private Map<String, Object> maps;

    public LRU(int capacity) {
        this.maps = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public void insert(String key, Object item) {
        Object o = maps.get(key);
        if (Objects.nonNull(o)) {
            maps.remove(key);
        }

        if (maps.size() == capacity) {
            maps.remove(maps.keySet().stream().findFirst().orElse(null));
        }
        maps.put(key, item);

    }

    public void read(String key) {

    }
}
