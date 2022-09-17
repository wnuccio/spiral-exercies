package exes.phonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneNumber {
    private final String s;
    private final Phone phone = new Phone();

    public PhoneNumber(String digits) {
        this.s = digits;
    }

    /*
       0 [a b c]
       1 [c d e]
       2 [e f g]
     */
    public List<String> combinations() {
        if (s.isEmpty()) return Collections.emptyList();
        return computeCombinationsFor(s);
    }

    private List<String> computeCombinationsFor(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) {
            result.add("");
            return result;
        }

        List<String> subCombinations = computeCombinationsFor(digits.substring(1));
        for (Character ch : phone.charsOf(digits.charAt(0)))
            for (String str : subCombinations)
                result.add(ch + str);
        return result;
    }

}
