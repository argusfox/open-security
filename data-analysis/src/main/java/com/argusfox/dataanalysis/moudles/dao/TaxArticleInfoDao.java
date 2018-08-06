package com.argusfox.dataanalysis.moudles.dao;


import com.argusfox.dataanalysis.moudles.entity.TaxArticleInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Fang Hao
 * @create 2018-06-25 15:29
 */
@Mapper
public interface TaxArticleInfoDao {

    /**
     * 保存税收法规
     *
     * @param taxType
     * @param title
     * @param issuingDate
     * @param issuingNo
     * @param articleUrl
     * @return
     */
    @Insert("INSERT INTO tax_article_info (tax_type, title, issuing_date, issuing_no, article_url) " +
            "VALUES (#{taxType}, #{title}, #{issuingDate}, #{issuingNo}, #{articleUrl} );")
    int saveTaxArticleInfo(@Param("taxType") String taxType,
                           @Param("title") String title,
                           @Param("issuingDate") String issuingDate,
                           @Param("issuingNo") String issuingNo,
                           @Param("articleUrl") String articleUrl);

    @Select("SELECT * FROM tax_article_info")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "taxType", column = "tax_type"),
            @Result(property = "title", column = "title"),
            @Result(property = "issuingDate", column = "issuing_date"),
            @Result(property = "issuingNo", column = "issuing_no"),
            @Result(property = "articleUrl", column = "article_url"),
            @Result(property = "mainBody", column = "main_body"),
            @Result(property = "attachment", column = "attachment"),
    })
    List<TaxArticleInfo> findAll();

    @Select("SELECT *  FROM tax_article_info WHERE main_body is NULL LIMIT #{index},50")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "taxType", column = "tax_type"),
            @Result(property = "title", column = "title"),
            @Result(property = "issuingDate", column = "issuing_date"),
            @Result(property = "issuingNo", column = "issuing_no"),
            @Result(property = "articleUrl", column = "article_url"),
            @Result(property = "mainBody", column = "main_body"),
            @Result(property = "attachment", column = "attachment"),
    })
    List<TaxArticleInfo> findAllIndex(@Param("index") Integer index);

    @Select("SELECT * FROM tax_article_info WHERE title = #{title}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "taxType", column = "tax_type"),
            @Result(property = "title", column = "title"),
            @Result(property = "issuingDate", column = "issuing_date"),
            @Result(property = "issuingNo", column = "issuing_no"),
            @Result(property = "articleUrl", column = "article_url"),
            @Result(property = "mainBody", column = "main_body"),
            @Result(property = "attachment", column = "attachment"),
    })
    List<TaxArticleInfo> findByTitle(@Param("title") String title);

    @Update("UPDATE tax_article_info SET main_body = #{mainBody} WHERE id = #{id};")
    int updateBody(@Param("id") Integer id, @Param("mainBody") String mainBody);
}

