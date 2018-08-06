CREATE TABLE `tax_article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tax_type` varchar(10) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `issuing_date` varchar(32) DEFAULT NULL,
  `issuing_no` varchar(100) DEFAULT NULL,
  `article_url` varchar(255) DEFAULT NULL,
  `main_body` longtext,
  `attachment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;