package watchers;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import utils.Screen;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWatch extends TestWatcher {
    Date date = new Date();
    SimpleDateFormat formater = new SimpleDateFormat("HHmmss");
//
//    @Override
//    @Step("method by succeeded")
//    protected void succeeded(Description description) {
//
//        System.out.println(Screen.getString());
//        Screen.takeScreen("CERTIFICATE" + formater.format(date));
//    }

    @Override
    protected void failed(Throwable e, Description description) {
        Screen.takeScreen(formater.format(date));

    }
}
