public class main {
    public static void main(String[] args) {
        PythonParser parser = new PythonParser();
        parser.addVariable("a", "1");
        parser.evaluate("1");
    }
}