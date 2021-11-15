import org.python.util.PythonInterpreter;
import java.io.ByteArrayOutputStream;

public class PythonParser {
    private final PythonInterpreter pyInterp = new PythonInterpreter();
    private final ByteArrayOutputStream pyOutput = new ByteArrayOutputStream();

    public PythonParser() {
        pyInterp.setOut(pyOutput);
    }

    public void addVariable(String varName, String value){
        pyInterp.exec(varName + "=" + value);
    }

    public String evaluate(String expr) {
        pyInterp.exec("print(eval(\"" + expr + "\"))");
        String pythonOutput = pyOutput.toString();
        return pythonOutput;
    }
}
