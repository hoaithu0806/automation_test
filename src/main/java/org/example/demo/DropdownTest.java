package org.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class DropdownTest {
    public static void main(String[] args) {
        WebDriver driver1 = new ChromeDriver();
        WebDriver driver2 = new ChromeDriver();

        driver1.get("http://localhost:53487/main.aspx");
        driver2.get("http://192.168.1.17:9902/bridge-search");

        Map<String, List<String>> dropdowns1 = getDropdownMap(driver1);
        Map<String, List<String>> dropdowns2 = getDropdownMap(driver2);

        // So sánh
        Set<String> allIds = new HashSet<>();
        allIds.addAll(dropdowns1.keySet());
        allIds.addAll(dropdowns2.keySet());

        for (String id : allIds) {
            List<String> values1 = dropdowns1.get(id);
            List<String> values2 = dropdowns2.get(id);

            if (values1 == null) {
                System.out.println("⚠ Web1 không có dropdown ID = " + id);
                continue;
            }
            if (values2 == null) {
                System.out.println("⚠ Web2 không có dropdown ID = " + id);
                continue;
            }

            if (values1.equals(values2)) {
                System.out.println("✅ Dropdown [" + id + "] giống nhau");
            } else {
                System.out.println("❌ Dropdown [" + id + "] khác nhau");
                System.out.println("   Web1: " + values1);
                System.out.println("   Web2: " + values2);
            }
        }

    }

    // Lấy tất cả dropdown (id -> list value/text)
    public static Map<String, List<String>> getDropdownMap(WebDriver driver) {
        Map<String, List<String>> dropdownMap = new HashMap<>();
        List<WebElement> dropdowns = driver.findElements(By.tagName("select"));

        for (WebElement dropdown : dropdowns) {
            String id = dropdown.getAttribute("id");
            if (id == null || id.isEmpty()) {
                continue; // bỏ qua nếu không có id
            }
            dropdownMap.put(id, getDropdownValues(dropdown));
        }
        return dropdownMap;
    }

    // Lấy danh sách value/text của 1 dropdown
    public static List<String> getDropdownValues(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            values.add(option.getText().trim()); // hoặc option.getAttribute("value")
        }
        return values;
    }
}
