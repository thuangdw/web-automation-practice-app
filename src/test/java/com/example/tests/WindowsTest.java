package com.example.tests;

import com.example.pages.WindowsPage;
import com.example.utils.TestBase;
import org.testng.annotations.Test;

public class WindowsTest extends TestBase {

    @Test
    public void testOpenNewTab() {
        WindowsPage p = new WindowsPage(driver).load();
        p.openNewTabAndSwitch();
        // switch back example not needed here
    }
}
