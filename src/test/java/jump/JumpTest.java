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

    @Test
    void four_length_array() {
        assertEquals(-1, Jump.jump(new int[]{0, 1, 1, 1}));
        assertEquals(1, Jump.jump(new int[]{3, 1, 1, 1}));
        assertEquals(2, Jump.jump(new int[]{2, 1, 1, 1}));
        assertEquals(3, Jump.jump(new int[]{1, 1, 1, 1}));
        assertEquals(2, Jump.jump(new int[]{1, 2, 1, 1}));
        assertEquals(2, Jump.jump(new int[]{2, 1, 2, 1}));
    }

    @Test
    void too_large_jump() {
        assertEquals(1, Jump.jump(new int[]{10, 1, 1, 1}));
        assertEquals(2, Jump.jump(new int[]{1, 10, 1, 1}));
    }

    @Test
    void large_jump() {
        assertEquals(1, Jump.jump(new int[]{5, 0, 0, 0, 0, 1}));
        assertEquals(-1, Jump.jump(new int[]{4, 0, 0, 0, 0, 1}));
    }

    @Test
    void large_arrays() {
        assertEquals(5, Jump.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
