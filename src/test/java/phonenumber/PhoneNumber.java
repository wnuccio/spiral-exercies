package phonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneNumber {
    private String s;
    private Phone phone = new Phone();

    public PhoneNumber(String s) {
        this.s = s;
    }

    public List<String> combinations() {
        if (s.isEmpty())
            return Collections.emptyList();

        List<String> list = new ArrayList<>();
        if (s.length() == 1) {
            Character[] chars1 = phone.charsOf(s.charAt(0));

            for (char ch1 : chars1)
                    list.add("" + ch1);

            return list;
        }

        Character[] chars1 = phone.charsOf(s.charAt(0));
        Character[] chars2 = phone.charsOf(s.charAt(1));

        for (char ch1 : chars1)
            for (char ch2 : chars2) {
                list.add("" + ch1 + ch2);
            }

        return list;

    }
}
