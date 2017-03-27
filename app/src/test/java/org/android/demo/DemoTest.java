package org.android.demo;

import org.android.demo.utils.AppiumInit;
import org.junit.Test;

import static org.android.demo.utils.Helpers.findById;
import static org.android.demo.utils.Helpers.setWait;
import static org.android.demo.utils.Helpers.text_exact;

public class DemoTest extends AppiumInit {

    @Test
    public void testApp(){
        setWait(10);
        findById("button2").click();
        text_exact("Article One");
        text_exact("Article Two");
    }
}
