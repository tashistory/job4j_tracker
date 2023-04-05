package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.hmap.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class ItemTest {
    @Test
    public void whenAscsort() {
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("fvfvfvvf"),
                new Item("gbbgbgf"), new Item("aadsdd")));
        List<Item> expected = new ArrayList<>(Arrays.asList(new Item("aadsdd"),
                new Item("fvfvfvvf"), new Item("gbbgbgf")));
        items.sort(new ItemAscByName());
        assertThat(items.toString()).isEqualTo(expected.toString());
    }

    @Test
    public void whenDescsort() {
        List<Item> items = new ArrayList<>(Arrays.asList(new Item("fvfvfvvf"),
                new Item("gbbgbgf"), new Item("aadsdd")));
        List<Item> expected = new ArrayList<>(Arrays.asList(new Item("gbbgbgf"),
                new Item("fvfvfvvf"), new Item("aadsdd")));
        items.sort(new ItemDescByName());
        assertThat(items.toString()).isEqualTo(expected.toString());
    }
}