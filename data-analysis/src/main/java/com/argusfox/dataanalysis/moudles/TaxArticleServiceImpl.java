package com.argusfox.dataanalysis.moudles;

import com.argusfox.dataanalysis.moudles.dao.TaxArticleInfoDao;
import com.argusfox.dataanalysis.moudles.entity.TaxArticleInfo;
import com.argusfox.dataanalysis.moudles.selenium.SeleniumService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author Fang Hao
 * @create 2018-06-25 10:56
 */
@Service
public class TaxArticleServiceImpl implements TaxArticleService {

    private static final Logger logger = LoggerFactory.getLogger(TaxArticleServiceImpl.class);

    @Resource
    private TaxArticleInfoDao taxArticleInfoDao;

    @Override
    @Transactional
    public void grabArticleBody(Integer index) {

        SeleniumService seleniumService = new SeleniumService();
        ChromeDriver driver = seleniumService.getDriver();
        List<TaxArticleInfo> taxArticleInfos = taxArticleInfoDao.findAllIndex(index);
        taxArticleInfos
                .stream()
                .filter(taxArticleInfo ->
                        StringUtils.isBlank(taxArticleInfo.getMainBody()))
                .forEach(taxArticleInfo -> {
                    try {
                        Thread.sleep(RandomUtils.nextLong(500L, 2000L));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    driver.get(taxArticleInfo.getArticleUrl());
                    String body = (String) driver.executeScript("return document.getElementById('Zoom2').innerHTML");
                    updateArticBody(taxArticleInfo.getId(),body);
                });
        driver.quit();//退出浏览器
    }

    @Override
    @Transactional
    public void grabTaxArticle() {
        SeleniumService seleniumService = new SeleniumService();
        ChromeDriver driver = seleniumService.getDriver();
        List<TaxArticleInfo> taxArticleInfos = new ArrayList();
        for (int i = 2; i <= 19; i++) {
            try {
                Thread.sleep(RandomUtils.nextLong(1000L, 5000L));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.switchTo().defaultContent();
            driver.switchTo().frame("leftList");
            if (i != 2) {
                driver.findElement(By.id("tree_link_" + i)).click();
            }
            String taxType = (String) driver.executeScript("return document.getElementById('tree_link_" + i + "').innerText");
            driver.switchTo().defaultContent();
            driver.switchTo().frame("rightList");
            String str = (String) driver.executeScript("return document.getElementById('searchForm').getElementsByTagName('table')[7].innerText");
            logger.info("页数:{}-{}", i, str.substring(1, str.indexOf("项")));

            int count = Integer.parseInt(str.substring(1, str.indexOf("项")));

            for (int j = 1; j <= count / 15 + 1; j++) {
                try {
                    Thread.sleep(RandomUtils.nextLong(1000L, 5000L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (j != 1) {
                    WebElement cPage = driver.findElement(By.id("cPage"));
                    cPage.sendKeys(String.valueOf(j));
                    cPage.submit();
                }
                if (j * 15 <= count) {
                    //tr
                    for (int tr = 1; tr <= 15; tr++) {
                        TaxArticleInfo taxArticleInfo = getTaxArticleInfo(driver, tr, taxType);
                        taxArticleInfos.add(taxArticleInfo);
                    }
                } else {
                    for (int tr = 1; tr <= count % 15; tr++) {
                        TaxArticleInfo taxArticleInfo = getTaxArticleInfo(driver, tr, taxType);
                        taxArticleInfos.add(taxArticleInfo);
                    }
                }
            }
        }
        saveTaxArticle(taxArticleInfos);
    }

    @Override
    public void grabTaxArticle(int i) {
        SeleniumService seleniumService = new SeleniumService();
        ChromeDriver driver = seleniumService.getDriver();
        List<TaxArticleInfo> taxArticleInfos = new ArrayList();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("leftList");
        try {
            Thread.sleep(RandomUtils.nextLong(1000L, 5000L));
//            Thread.sleep(9000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElement(By.id("tree_link_" + i)).click();
//        String taxType = (String) driver.executeScript("return document.getElementById('tree_link_" + i + "').innerText");
        String taxType = null;
        driver.switchTo().defaultContent();
        driver.switchTo().frame("rightList");
        String str = (String) driver.executeScript("return document.getElementById('searchForm').getElementsByTagName('table')[7].innerText");
        logger.info("页数:{}-{}", i, str.substring(1, str.indexOf("项")));

        int count = Integer.parseInt(str.substring(1, str.indexOf("项")));

        for (int j = 1; j <= count / 15 + 1; j++) {
            try {
                Thread.sleep(RandomUtils.nextLong(1000L, 5000L));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (j != 1) {
                driver.executeScript("goPage(" + j + ")");
//                WebElement cPage = driver.findElement(By.id("cPage"));
//                cPage.sendKeys(String.valueOf(j));
            }
            if (j * 15 <= count) {
                //tr
                for (int tr = 1; tr <= 15; tr++) {
                    TaxArticleInfo taxArticleInfo = getTaxArticleInfo(driver, tr, taxType);
                    taxArticleInfos.add(taxArticleInfo);
                }
            } else {
                for (int tr = 1; tr <= count % 15; tr++) {
                    TaxArticleInfo taxArticleInfo = getTaxArticleInfo(driver, tr, taxType);
                    taxArticleInfos.add(taxArticleInfo);
                }
            }
        }

        saveTaxArticle(taxArticleInfos);
        driver.quit();//退出浏览器
    }

    private TaxArticleInfo getTaxArticleInfo(ChromeDriver driver, int tr, String taxType) {
        TaxArticleInfo taxArticleInfo = new TaxArticleInfo();
        //文章链接

        String url = (String) driver.executeScript("return document.getElementById('searchForm')" +
                ".getElementsByTagName('table')[8]" +
                ".getElementsByTagName('tbody')[0]" +
                ".getElementsByTagName('tr')[" + tr + "]" +
                ".getElementsByTagName('td')[0]" +
                ".getElementsByTagName('a')[0].href");
        taxArticleInfo.setArticleUrl(url);
        //文章标题
        String title = (String) driver.executeScript("return document.getElementById('searchForm')" +
                ".getElementsByTagName('table')[8]" +
                ".getElementsByTagName('tbody')[0]" +
                ".getElementsByTagName('tr')[" + tr + "]" +
                ".getElementsByTagName('td')[0]" +
                ".getElementsByTagName('a')[0]" +
                ".innerText");
        taxArticleInfo.setTitle(title);
        //发文日期
        String date = (String) driver.executeScript("return document.getElementById('searchForm')" +
                ".getElementsByTagName('table')[8]" +
                ".getElementsByTagName('tbody')[0]" +
                ".getElementsByTagName('tr')[" + tr + "]" +
                ".getElementsByTagName('td')[1]" +
                ".innerText");
        taxArticleInfo.setIssuingDate(date);
        //文号
        String num = (String) driver.executeScript("return document.getElementById('searchForm')" +
                ".getElementsByTagName('table')[8]" +
                ".getElementsByTagName('tbody')[0]" +
                ".getElementsByTagName('tr')[" + tr + "]" +
                ".getElementsByTagName('td')[2]" +
                ".innerText");
        taxArticleInfo.setIssuingNo(num);
        taxArticleInfo.setTaxType(taxType);
        return taxArticleInfo;
    }

    private void saveTaxArticle(List<TaxArticleInfo> taxArticleInfos) {
        taxArticleInfos
                .stream()
                .filter(taxArticleInfo ->
                        !Optional.ofNullable(taxArticleInfoDao.findByTitle(taxArticleInfo.getTitle()))
                                .isPresent())
                .forEach(taxArticleInfo -> saveTaxArticle(taxArticleInfo));
//        taxArticleInfos.forEach(taxArticleInfo -> saveTaxArticle(taxArticleInfo));
    }

    private void saveTaxArticle(TaxArticleInfo taxArticleInfo) {
        taxArticleInfoDao.saveTaxArticleInfo(
                taxArticleInfo.getTaxType(),
                taxArticleInfo.getTitle(),
                taxArticleInfo.getIssuingDate(),
                taxArticleInfo.getIssuingNo(),
                taxArticleInfo.getArticleUrl());
    }

    @Override
    @Transactional
    public void savaTax(String taxType, String title, String issuingDate, String issuingNo, String articleUrl) {
        taxArticleInfoDao.saveTaxArticleInfo(taxType, title, issuingDate, issuingNo, articleUrl);
    }

    @Override
    public List<TaxArticleInfo> findAll() {
        return taxArticleInfoDao.findAll();
    }

    @Override
    @Transactional
    public void updateArticBody(Integer id, String body) {
        taxArticleInfoDao.updateBody(id,body);
    }


}
