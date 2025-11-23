package com.example.tests;

import com.example.pages.FramesPage;
import com.example.utils.TestBase;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {

    @Test
    public void testIframeTyping() {
        FramesPage p = new FramesPage(driver).load();
        p.typeInFrame("text inside iframe");
        // no assert by default, adapt to DOM feedback if available
    }
}
