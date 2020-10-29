package org.zhangzhuo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhangzhuo.config.AlipayConfig;
import org.zhangzhuo.entity.Order;
import org.zhangzhuo.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Auther :${Mr.zhang}
 * Time:2020/9/8
 */
@Controller
public class ALiPayController {
    @Autowired
    private OrderService orderService;

    /**
     * 支付页面
     * @param orderId
     * @return
     */
    @GetMapping(value = "alipay",produces = "text.html;charset = UTF-8")
    public @ResponseBody String getPay(Long orderId){
        Order byOrderId = orderService.getByOrderId(orderId);
        return zfb(byOrderId);
    }
    //支付宝
    private String zfb(Order order){
        //初始化defaultAlipayClient
        DefaultAlipayClient defaultAlipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,"json",
                AlipayConfig.charset,AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
        payRequest.setReturnUrl(AlipayConfig.return_url);
        payRequest.setNotifyUrl(AlipayConfig.notify_url);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        Long out_trade_no = order.getId();
        //获取金额  必填
        BigDecimal total_amount = order.getReduceMoney();
        //订单名称
        String subject = "G08商城订单";
        //获取留言  可不填
        String body = order.getRemark();

        payRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        // alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        // + "\"total_amount\":\""+ total_amount +"\","
        // + "\"subject\":\""+ subject +"\","
        // + "\"body\":\""+ body +"\","
        // + "\"timeout_express\":\"10m\","
        // + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        // 请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        String result;


        try {
            result = defaultAlipayClient.pageExecute(payRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            result =  "支付跳转异常";
        }
        return result;
    }



    @GetMapping("/alipay/notify_url")
    public void getNotifyUrl(HttpServletResponse response, HttpServletRequest request){
        HashMap<String, String> params = new HashMap<>();
        Map<String, String[]> parameterParams = request.getParameterMap();
        for (Iterator<String> item = parameterParams.keySet().iterator();item.hasNext();){
            String next = item.next();
            String[] strings = parameterParams.get(next);
            String str = "";
            for (int i = 0;i<strings.length;i++) {
                str = (i == strings.length - 1)?str +strings[i] : str + strings[i] +",";
            }
        }
    }







}
