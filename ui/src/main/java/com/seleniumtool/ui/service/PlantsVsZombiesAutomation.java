package com.seleniumtool.ui.service;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class PlantsVsZombiesAutomation {
    public static void main(String[] args) {
        try {
            // Khởi động WinAppDriver
            URL winAppDriverUrl = new URL("http://127.0.0.1:4723");

            // Thiết lập Desired Capabilities
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:/path/to/PlantsVsZombies.exe");

            // Tạo WindowsDriver
            WindowsDriver<WindowsElement> driver = new WindowsDriver<>(winAppDriverUrl, capabilities);

            // Thực hiện các thao tác tự động hóa
            // Ví dụ: Tìm và nhấp vào một phần tử trong game
            WindowsElement startButton = driver.findElementByName("Start");
            startButton.click();

            // Thêm các thao tác khác tùy theo nhu cầu
            // ...

            // Đóng driver
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
