package prefix;

public class Words {
    private String[] s;

    public Words(String... s) {
        this.s = s;
    }

    public String commonPrefix() {
        return s[0];
    }
}
