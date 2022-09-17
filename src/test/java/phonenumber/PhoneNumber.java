package phonenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumber {
    private String s;
    private Phone phone = new Phone();

    public PhoneNumber(String s) {
        this.s = s;
    }

    public List<String> combinations() {
        if (s.isEmpty())
            return Collections.emptyList();

        if (s.length() == 1) {
            Character[] chars = phone.charsOf(s.charAt(0));
            return Arrays.asList(chars).stream().map(String::valueOf).collect(Collectors.toList());
        }

        Character[] chars1 = phone.charsOf(s.charAt(0));
        Character[] chars2 = phone.charsOf(s.charAt(1));

        List<String> list = new ArrayList<>();
        for (char ch1 : chars1)
            for (char ch2 : chars2) {
                list.add("" + ch1 + ch2);
            }

        return list;

    }
}
