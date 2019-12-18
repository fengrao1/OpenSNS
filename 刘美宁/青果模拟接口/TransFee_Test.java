package com.example.demo.QGtest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 刘美宁
 *    计算运费
 */
@RestController
public class TransFee_Test {//不需要登录
	//以goodsId=1为示例
	@RequestMapping(value = "/common/getTransportFee",method = RequestMethod.GET)
    public Map<String,String> getwithParam(@RequestParam("goodsId") String id,
                                           @RequestParam("addressDetail") String addressDetail){

        if(id.equals("1")&&addressDetail.equals("浙江省_杭州市_滨江区")) {
            Map<String,String> result=new HashMap<>();
            result.put("message","success");
            result.put("result","6.0");
            result.put("code","200");
            return result;
		}
        
        Map<String,String> resultfail=new HashMap<>();
        resultfail.put("message","请求失败");
        resultfail.put("code","400");
        return resultfail;

    }
	 
}
