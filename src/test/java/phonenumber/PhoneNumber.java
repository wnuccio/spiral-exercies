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
       0 [a b c]
       1 [c d e]
       2 [e f g]
     */
    private List<String> combination(String s) {
        List<String> result = new ArrayList<>();

        if (s.isEmpty())
            return result;

        if (s.length() == 1) {
            for (Character ch : phone.charsOf(s.charAt(0)))
                result.add(ch.toString());
            return result;
        }

        List<String> subCombinations = combination(s.substring(1));
        for (Character ch : phone.charsOf(s.charAt(0)))
            for (String str : subCombinations)
                result.add(ch + str);
        return result;
    }

    public List<String> combinations() {
        return combination(s);
    }

}
