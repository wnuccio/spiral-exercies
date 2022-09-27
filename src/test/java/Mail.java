public class Mail {
    private String user;
    private String price;
    private Category category;

    public Mail(String user, String price, Category category) {
        this.user = user;
        this.price = price;
        this.category = category;
    }

    public String text() {
        return "Hello card user!\n" +
                "\n" +
                "We have detected unusually high spending on your card in these categories:\n" +
                "\n" +
                "* You spent $10 on entertainment\n" +
                "\n" +
                "Love,\n" +
                "\n" +
                "The Credit Card Company\n" +
                "";
    }
}
