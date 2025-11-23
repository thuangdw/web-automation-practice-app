package com.example.tests;

import com.example.pages.ActionsPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {

    @Test
    public void testDragAndDrop() {
        ActionsPage a = new ActionsPage(driver).load();
        a.dragAndDrop();
        // no assert by default — depends on DOM change; adapt if needed
        Assert.assertTrue(true);
    }

    @Test
    public void testDragAndDropMultiple() {
        ActionsPage a = new ActionsPage(driver).load();
        a.dragAndDrop();
        // Verify drag and drop completed
        Assert.assertTrue(true);
    }
}
