package phonenumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    private String s;
    private Phone phone = new Phone();

    public PhoneNumber(String s) {
        this.s = s;
    }

    public List<String> combinations() {
        Character[] chars = phone.charsOf(s.charAt(0));
        return Arrays.asList(chars).stream().map(String::valueOf).collect(Collectors.toList());
    }
}
