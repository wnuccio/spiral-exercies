package phonenumber;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
    public Map<Character, char[]> map;

    PhoneNumber() {
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
    }
}
