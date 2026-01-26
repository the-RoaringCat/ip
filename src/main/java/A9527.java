public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";



    public static void greetUser() {
        String logo = """
                \t  ___  ____  ____  _____
                \t / _ \\| ___||___ \\|___  |
                \t| (_) |___ \\  __) |  / /\s
                \t \\__/ |___) )/ __/_ / /
                \t   /_/|____/|_____//_/
                """;
        System.out.println(LINE + "\tHello I'm\n" + logo + "\tWhat can I do for you?\n" +LINE);

    }

    public static void byeUser() {
        System.out.println(LINE + "\tBye. Hope to see you again soon!\n" + LINE);
    }

    public static void main(String[] args) {
        greetUser();
        Echo.echoUser();
    }
}
