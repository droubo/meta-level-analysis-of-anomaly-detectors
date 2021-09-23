import com.mathworks.engine.MatlabEngine;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
class Test{
    public static void main(String args[]) throws InterruptedException, ExecutionException{
        System.loadLibrary("nativemvm");
        Future<MatlabEngine> engine = MatlabEngine.startMatlabAsync();
        MatlabEngine eng = engine.get();
        // Change directory and evaluate your function
        eng.eval("cd 'C:\\Users\\Droubo\\Desktop\\LODA_new'");
        eng.feval("run_loda", "Ionosphere_shuffleStratified.csv", 256, "dense", "continuous", 500, "scores");
    }
}