package com.argusfox.dataanalysis.moudles.entity;

import java.io.Serializable;

/**
 * 个税法规
 *
 * @author Fang Hao
 * @create 2018-06-25 14:09
 */

public class TaxArticleInfo implements Serializable {

    private static final long serialVersionUID = 1755464694222120655L;

    private Integer id;
    /**
     * 税种
     */
    private String taxType;
    /**
     * 标题
     */
    private String title;
    /**
     * 发文日期
     */
    private String issuingDate;
    /**
     * 文号(发文字号)
     */
    private String issuingNo;
    /**
     * 文章链接
     */
    private String articleUrl;
    /**
     * 文章正文
     */
    private String mainBody;
    /**
     * 附件
     */
    private String attachment;

    public TaxArticleInfo() {
    }

    public TaxArticleInfo(Integer id,
                          String taxType,
                          String title,
                          String issuingDate,
                          String issuingNo,
                          String articleUrl,
                          String mainBody,
                          String attachment) {
        this.id = id;
        this.taxType = taxType;
        this.title = title;
        this.issuingDate = issuingDate;
        this.issuingNo = issuingNo;
        this.articleUrl = articleUrl;
        this.mainBody = mainBody;
        this.attachment = attachment;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getIssuingNo() {
        return issuingNo;
    }

    public void setIssuingNo(String issuingNo) {
        this.issuingNo = issuingNo;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "TaxArticleInfo{" +
                "id=" + id +
                ", taxType='" + taxType + '\'' +
                ", title='" + title + '\'' +
                ", issuingDate='" + issuingDate + '\'' +
                ", issuingNo='" + issuingNo + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", mainBody='" + mainBody + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
