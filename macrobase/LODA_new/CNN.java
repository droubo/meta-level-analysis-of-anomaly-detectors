import com.mathworks.engine.*;
public class CNN
{
    public static void main(String[] args) throws Exception{
        MatlabEngine eng = MatlabEngine.startMatlab();
        double[] a = {2.0 ,4.0, 6.0};
        double[] roots = eng.feval("sqrt", a);
        eng.close();
    }
}