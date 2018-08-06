import com.argusfox.Application;
import com.argusfox.dataanalysis.moudles.TaxArticleService;
import com.argusfox.dataanalysis.moudles.entity.TaxArticleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {
    private static final Logger log = LoggerFactory.getLogger(ApplicationTest.class);

    //    @Resource
//    private TaxApiRemote taxApiRemote;
//    @Resource
//    private GrabRemote grabRemote;
    @Resource
    private TaxArticleService taxArticleService;
//    private static final String orderNo = "0101022018061914151066545";

    @Test
    public void TaxTest() {
        String body;
//         body = taxApiRemote.city();
//         body = taxApiRemote.info("310100");
//         body = taxApiRemote.imgCode(orderNo,"4","1");


//        Map<String, String> map= new HashMap<>(3);
////        map.put("34","wanglc");//账户
////        map.put("38","hxpti123");//密码
////        map.put("imgCode6","py9r");//验证码
//        map.put("24","py9r");//验证码
//        map.put("25","py9r");//验证码
//        body = taxApiRemote.submit(
//                orderNo,
//                "6",
//                "350100",map);

//        body = taxApiRemote.status(orderNo);
//        body = taxApiRemote.allDetail(orderNo);


//        log.info(body);
    }

    @Test
    public void GrabTest() {
//        taxArticleService.savaTax("增值税",
//                "国家税务总局关于新办纳税人首次申领增值税发票有关事项的公告",
//                "2018-06-11",
//                "国家税务总局公告2018年第29号",
//                "http://hd.chinatax.gov.cn/guoshui/action/GetArticleView1.do?id=15151137&flag=1");
//        List<TaxArticleInfo> taxArticleInfos = taxArticleService.findAll();
//        System.out.println(taxArticleInfos);

//        taxArticleService.grabTaxArticle(19);
//        taxArticleService.updateArticBody(1, "sb");
        for (int i = 0; i <= 250; i += 50) {
            taxArticleService.grabArticleBody(0);
        }
    }

}
