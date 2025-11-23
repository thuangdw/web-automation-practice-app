package com.example.tests;

import com.example.pages.TablesPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TablesTest extends TestBase {

    @Test
    public void testTableReads() {
        TablesPage t = new TablesPage(driver).load();
        int rows = t.getRowCount();
        Assert.assertTrue(rows > 0, "Expected at least one row in table");
        String firstCell = t.getCell(0, 0);
        System.out.println("First cell: " + firstCell);
    }
}
