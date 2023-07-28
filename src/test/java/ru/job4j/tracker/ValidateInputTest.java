package ru.job4j.tracker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {
    @Disabled

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Disabled
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Disabled
    @Test
    public void whenInvalidInputNegativ() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}