package com.example.tests;

import com.example.pages.FormsPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends TestBase {

    @Test
    public void testFormSubmit() {
        FormsPage forms = new FormsPage(driver).load();
        forms.enterName("Tom").enterEmail("tom@example.com").submit();
        Assert.assertTrue(forms.getResult().toLowerCase().contains("submitted"));
    }
}
