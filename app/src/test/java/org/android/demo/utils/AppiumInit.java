package org.android.demo.utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import static org.android.demo.utils.Helpers.driver;

public abstract class AppiumInit {

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        initCapabilities(capabilities);
        initDriver(capabilities);
        initJenkins(capabilities);
        Helpers.init(driver);
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

    private void initCapabilities(final DesiredCapabilities capabilities){
        String apkPath = getApkPath();
        capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android for tests");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("app", apkPath);
    }

    private String getApkPath() {
        String apkPath = System.getProperty("user.dir") + "/app-debug.apk";
        if (!new File(apkPath).exists()) {
            apkPath = System.getProperty("user.dir") + "/app/app-debug.apk";
        }
        return apkPath;
    }

    private void initJenkins(final DesiredCapabilities capabilities) {
        capabilities.setCapability("testobject_api_key", "9848-APK");
        capabilities.setCapability("testobject_device", "Nexus_6_API_25");
    }

    private void initDriver(final DesiredCapabilities capabilities) throws Exception{
        driver = new AndroidDriver(serverAddress(), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private URL serverAddress(){
        try {
            return  new URL ("http://127.0.0.1:4723/wd/hub");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
