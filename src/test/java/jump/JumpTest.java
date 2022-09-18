package jump;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpTest {
    @Test
    void zero_jump_for_one_length_array() {
        assertEquals(0, Jump.jump(new int[]{1}));
    }
}
