package phonenumber;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    private String s;
    private Phone phone = new Phone();

    public PhoneNumber(String s) {
        this.s = s;
    }

    /*
        [a b c]
        [c d e]
        [e f g]

     */

    private List<String> combination(Character[] chars) {
        List<String> list = new ArrayList<>();
        for (char ch1 : chars)
            list.add("" + ch1);
        return list;
    }

    public List<String> combinations() {
        Character[] chars = s.isEmpty() ? new Character[]{} : phone.charsOf(s.charAt(0));
        if (s.length() <= 1) return combination(chars);

        List<String> list = new ArrayList<>();
        Character[] chars1 = phone.charsOf(s.charAt(0));
        Character[] chars2 = phone.charsOf(s.charAt(1));

        for (char ch1 : chars1)
            for (char ch2 : chars2) {
                list.add("" + ch1 + ch2);
            }

        return list;

    }
}
