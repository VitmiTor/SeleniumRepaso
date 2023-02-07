package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.FileManager;
import utilities.Logs;

public class SuiteListeners implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        new FileManager().deleteScreenShotDirectory();
        new FileManager().redirectStdErr();
        Logs.startSuite(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Logs.info("terminando la suite");
    }
}
