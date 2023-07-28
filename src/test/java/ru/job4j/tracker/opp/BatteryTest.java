package ru.job4j.tracker.opp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.oop.Battery;

import static org.assertj.core.api.Assertions.assertThat;

public class BatteryTest {
    @Disabled
    @Test
    public void whenThis30Another50ThenAnotherLoadEqual80() {
        Battery charger = new Battery(30);
        Battery another = new Battery(50);
        charger.exchange(another);
        int expected = 80;
        assertThat(another.about()).isEqualTo("My charge: " + expected + "%");
    }

    @Disabled
    @Test
    public void whenThis80Another20ThenThisLoadEqual0() {
        Battery charger = new Battery(80);
        Battery another = new Battery(20);
        charger.exchange(another);
        int expected = 0;
        assertThat(charger.about()).isEqualTo("My charge: " + expected + "%");
    }

    @Disabled
    @Test
    public void whenThis95Another0ThenAnotherLoadEqual80() {
        Battery charger = new Battery(95);
        Battery another = new Battery(0);
        charger.exchange(another);
        int expected = 95;
        assertThat(another.about()).isEqualTo("My charge: " + expected + "%");
    }
}