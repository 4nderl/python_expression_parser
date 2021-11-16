import org.python.util.PythonInterpreter;
import java.io.ByteArrayOutputStream;

public class PythonParser {
    private final PythonInterpreter pyInterp = new PythonInterpreter();
    private final ByteArrayOutputStream pyOutput = new ByteArrayOutputStream();

    public PythonParser() {
        pyInterp.setOut(pyOutput);
    }

    public void addVariable(String varName, String value){
        pyInterp.exec(filter_input(varName) + "=" + filter_input(value));
    }

    public String evaluate(String expr) {
        pyInterp.exec("print(eval(\"" + filter_input(expr) + "\"))");
        String pythonOutput = pyOutput.toString();
        return pythonOutput;
    }

    private String filter_input(String input){
        return input.replaceAll("\"", "").strip();
    }
}
