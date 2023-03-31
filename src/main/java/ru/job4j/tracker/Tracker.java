package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            item.setId(id);
            items.set(i, item);
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items.get(i).getName())) {
               rsl.add(k , items.get(i));
                // rsl[k] = items[i];
                k++;
            }
        }
        //return Arrays.copyOf(rsl, k);
        return rsl;
    }

    public boolean delete(int id) {
       int i = indexOf(id);
       boolean rsl = i != -1;
       if (rsl) {
           items.remove(i);
         //   System.arraycopy(items, i + 1, items, i, size - i - 1);
          // items[size - 1] = null;
           // size--;
        }
        return rsl;
    }
}