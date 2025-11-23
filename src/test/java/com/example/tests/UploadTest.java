package com.example.tests;

import com.example.pages.UploadPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class UploadTest extends TestBase {

    @Test
    public void testFileUpload() {
        UploadPage up = new UploadPage(driver).load();
        File sample = new File("sample_upload.txt");
        // create a small sample file if not exists (optional)
        up.uploadFile(sample.getAbsolutePath());
        String status = up.getUploadStatus();
        System.out.println("Upload status: " + status);
        // adapt to your page's upload result verification
        Assert.assertTrue(status != null);
    }
}
