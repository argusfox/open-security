package com.argusfox.dataanalysis.moudles;

import com.argusfox.dataanalysis.moudles.entity.TaxArticleInfo;

import java.util.List;

/**
 * @author Fang Hao
 * @create 2018-06-25 10:55
 */
public interface TaxArticleService {


    void grabArticleBody(Integer index);

    void grabTaxArticle();

    void grabTaxArticle(int i);

    /**
     * test
     *
     * @param taxType
     * @param title
     * @param issuingDate
     * @param issuingNo
     * @param articleUrl
     */
    void savaTax(String taxType,
                 String title,
                 String issuingDate,
                 String issuingNo,
                 String articleUrl);

    List<TaxArticleInfo> findAll();

    /**
     *
     */
    void updateArticBody(Integer id, String body);
}
