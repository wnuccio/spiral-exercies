public class Mail {
    private final String user;
    private final String price;
    private final Category category;

    public Mail(String user, String price, Category category) {
        this.user = user;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "user='" + user + '\'' +
                ", price='" + price + '\'' +
                ", category=" + category +
                '}';
    }

    public String text() {
        return String.format("Hello card user!\n" +
                "\n" +
                "We have detected unusually high spending on your card in these categories:\n" +
                "\n" +
                "* You spent $%s on %s\n" +
                "\n" +
                "Love,\n" +
                "\n" +
                "The Credit Card Company\n" +
                "", price, category.asName());
    }
}
