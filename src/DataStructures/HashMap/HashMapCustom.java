package DataStructures.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HashMapCustom<K, V> {
    private class Key {
        K key;
        V value;
        public Key(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int DEFAULT_SIZE = 16;
    private Object[] map; // List<Key>
    private int size;
    private int items;

    public V get(K key) {
        return ((ArrayList<Key>)map[key.hashCode() % this.size])
                .stream()
                .filter((k) -> k.key.hashCode() == key.hashCode())
                .findFirst()
                .get()
                .value;
    }

    public V getOrDefault(K key, V def) {
        boolean hasKey = false;
        for (K k : this.keySet()) {
            if (key.hashCode() == k.hashCode()) {
                return this.get(key);
            }
        }
        return def;
    }

    public void resize() {
        this.size = this.size * 2;
        Object[] newMap = new Object[size];
        for(int i = 0; i < size; i++) {
            newMap[i] = new ArrayList<Key>();
        }
        for(Object keys : this.map) {
            for (Key key : (ArrayList<Key>)keys) {
                int idx = key.key.hashCode() % this.size;
                ((ArrayList<Key>)newMap[idx]).add(new Key(key.key, key.value));
            }
        }

        this.map = newMap;
    }

    public void put(K key, V value) {
        int idx = key.hashCode() % this.size;
        if (this.getOrDefault(key, null) == null) {
            this.items++;
        }
        if (items == size-1) {
            this.resize();
        }
        ((ArrayList<Key>)map[idx]).add(new Key(key, value));
    }

    public List<K> keySet() {
        return (new ArrayList<Key>(Arrays.asList((Key[])map)))
                .stream()
                .map((obj) -> obj.key)
                .collect(Collectors.toList());
    }

    public HashMapCustom(int size) {
        this.size = size;
        this.items = 0;
        this.map = new Object[size];
        for (int i = 0; i < size; i++) {
            map[i] = new ArrayList<Key>();
        }
    }

    public HashMapCustom() {
        this.size = this.DEFAULT_SIZE;
        this.items = 90;
        this.map = new Object[size];
        for (int i = 0; i < size; i++) {
            map[i] = new ArrayList<Key>();
        }
    }

    public static void driver() {
        HashMapCustom<Integer, Boolean> map = new HashMapCustom<>();
        map.put(1, true);
        map.get(1); // is true;
        map.getOrDefault(2, false);
    }
}
