package jump;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpTest {
    @Test
    void zero_jump_for_one_length_array() {
        assertEquals(0, Jump.jump(new int[]{0}));
        assertEquals(0, Jump.jump(new int[]{1}));
        assertEquals(0, Jump.jump(new int[]{2}));
    }

    @Test
    void jump_for_two_length_array() {
        assertEquals(-1, Jump.jump(new int[]{0, 1}));
        assertEquals(1, Jump.jump(new int[]{1, 1}));
        assertEquals(1, Jump.jump(new int[]{1, 2}));
        assertEquals(1, Jump.jump(new int[]{2, 1}));
    }

    @Test
    void three_length_array() {
        assertEquals(-1, Jump.jump(new int[]{0, 1, 1}));
        assertEquals(2, Jump.jump(new int[]{1, 1, 1}));
        assertEquals(-1, Jump.jump(new int[]{1, 0, 1}));
        assertEquals(1, Jump.jump(new int[]{2, 0, 1}));
        assertEquals(1, Jump.jump(new int[]{2, 0, 0}));
        assertEquals(1, Jump.jump(new int[]{3, 1, 0}));
    }
}
