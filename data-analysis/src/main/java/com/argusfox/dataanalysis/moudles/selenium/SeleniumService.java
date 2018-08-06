package com.argusfox.dataanalysis.moudles.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

/**
 * @author fanghao
 * @create 2018-03-19 16:03
 */
@Component
public class SeleniumService {

    /**
     * selenium 火狐浏览器驱动
     */
//    private static FirefoxDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
        //default为火狐默认
//        FirefoxProfile profile = allProfiles.getProfile("default");
//        driver = new FirefoxDriver(profile);
    }

    public ChromeDriver getDriver() {
        ChromeDriver driver = new ChromeDriver();
//        driver.get("http://hd.chinatax.gov.cn/guoshui/main.jsp");
        return driver;


        /**
         * WebDriver自带了一个智能等待的方法。
         dr.manage().timeouts().implicitlyWait(arg0, arg1）；
         Arg0：等待的时间长度，int 类型 ；
         Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
         */
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        // 重置输入框
//        driver.executeScript("$('btn_cz').click();");
        //定位密码输入框
//        WebElement _ocx_password = driver.findElement(By.id("_ocx_password"));


//        driver.switchTo().frame("Editor1");
//        driver.switchTo().frame("eWebEditor");
/*        for (int i = 2; i < 20; i++) {

        }*/

/*        driver.switchTo().frame("leftList");
        driver.findElement(By.id("tree_tree_19")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("rightList");

        driver.findElement(By.id("cPage")).sendKeys("3");
        Object str7 = driver.executeScript("return document.getElementById('searchForm').getElementsByTagName('table')[7].innerText;");
        Object str8 = driver.executeScript("return document.getElementById('searchForm').getElementsByTagName('table')[8].innerHTML;");
        System.out.println("页码__________" + str7);
        System.out.println("数据__________" + str8);*/

        //$('#searchForm>table>tbody>tr>td>table:nth-child(3)>tbody>tr>td')

//$('#searchForm>table>tbody>tr>td>table:last-of-type')
//
//document.getElementById('searchForm').getElementsByTagName('table')[7]
//
//
//        WebElement tree_tree_19 = driver.findElement(By.id("tree_tree_19"));
//        tree_tree_19.click();

//        _ocx_password.sendKeys("1");

//        String script = (String) driver.executeScript("return getPdw('_ocx_password'," + ghost.getRandoms() + ");");

    }


}

