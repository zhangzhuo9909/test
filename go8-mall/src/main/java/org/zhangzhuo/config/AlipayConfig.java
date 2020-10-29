package org.zhangzhuo.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101800714066";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCyaMuHOmzNCTXUwG/atCr9xOau6tAXJsPylFpF7DdU87bysu8Jbj79GTH/ewkXf1t9cBwaGPYc7XReNwhh6OwrMtkIdRlySnpksLMvOj0e6BSYFKCcUgu91QbuQvHE4V18U55fqaQXUmBBb++oLt05xvRe18Rui4yGdsOanNncTZ/RXNPkHJ7AZT3tR/4aLk+cvQZ05peLabOLMxBy0YgQ7fgvOpr0CEQ4gyzcf5bFvS5xF96In6nwOQvplodIv8RQf862Z86EoQZH6KdwaYXqfCc5QflVTexREEG5qNnxajtynnD3iaK9Dl04yJ/Wg+a9KwwsDRuTgc1PGDNis4ldAgMBAAECggEAMPAwDBsJp0CEhKR4yjwrosq1IHwGsqMOkucA0DdYgjQMFgzhJuwX2SNlJJhiSRDFTuZGvx3jvNGh3wongXv79GmRQRGl9kTZx+70Z9sI0waER6c420hiMiNSMF8qpH/RPf5N7h3BhigxgSGsUqzwQB4EAFQdbNlYpbXEOBAYbqZjD1CtWQqj5ksiDIpV/Uk0XNqOb8JqjQdMlJcP0RM8Y75dtA4bIjQ+tOe2i1v1foKrrN1upqqeWvSAyl9sUycZ8too5Z0hdx9F7sU+mt0PHbFA90rNfWBlthB59DKk4JuL1BiYv1h8IbE5P07yWtGHkOPWa05wDurMBsVzAkGvPQKBgQDaeVwOvtnxPzmE3Ev2PgtBhBPcQ7mO4NW9j/TuRFy5YxDQZOsqPKnSCHGj1dH14/6MSIyo9dV3zmIXHx86YwQbtZJsLsGIBcZ0cAdFbVB7Yi1jSkhIjTgXr57JqOuhoxmgl4X8YasYgowUG+6jYkzCym4HCrDgP603tGIel6H29wKBgQDRDbqOLnlj6Tmd3y4mQRzsJXbOerOHuixhspCQxUaa1IBqW7Ur0RTsjbUfbq7elDBiHJDpjn/nO9DzTCLfjR+Cz9CNNi3/6pm7d6fGZ8+TOtH+5TILAZ5ApuFiWneu00kt75wjh6AlWM62+/QQrb+SiIcPBn2bKRGIwFssbBqJSwKBgA59vEByIkyhL/SDFDrKFL8MvrB+gYFbonHHaaygNjJJwuS/vOV5Tp5S1w7R8PJJZCnz6fiPDdC7jMAR3WVnCe+4lHS+iTG3iFlS0Pim7o6wjWgnljHRxCW2DWc84BxBkEKZqlZ6N/oRNq9ixuppa8QD31ZyPBczwg6O1W9ICYMzAoGBAMUpboXD/QamoolrQIohpNZuqvMntARRKKRnlYKEHAfQXOByZ5bQlSxYpbbkW5ZeKpeNm3o6xBRgTLv5VXaDEXH87xMPQyj2qFCvFBPCOnn/4qfEn4LT3t3Yxf5NlkzSxlTFg/vaYMZ4UFUxoMjOJTxc+QvJslLQ09GmoRZvSkOrAoGATPmC9yHEKCCfR61VTk+NuDqcdJdAZSS3wVyuEDc/CbXAERKGjYGFjaRPYAvAqHThq/1GE92m7o9BErykqvJ+FFgeYE6fHgn3rPvwgQwlPu3QD/cnkXn+rHbCkZyXJjAK/MVfRF44DphwSRzr85DMVkdwK5Av+15+jqdjVg4QjvM=";
	
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiDeeUOZXuo6ybey6iHukZwa4IoYiZkWZnYyGL+n3cUPj2Ydcffvelb1F1eK/hwN3H4b2dUF7KUyFb1srHZS76qr2ej+04q9blUayVQ0vNwNVjCZEMqRuC17O+xSiGsgXJlI2bS4BQUNrD9qfNECBzc1UMnNRlAgejUfMc+NPdXKil7XjFKgmARhrSZGvjbOpXrQlJ8tO9TBjsy342CEuyEVv0tpqHDaWV7NzqjIG6lGOAqemU5Puh0QLGmXXwDNjsBOZn1wyzqVPcriDwJCGhXl5jRs68iz0hw70fr88k/32PH0mmNgdA0bcEW5vl5w9C1LfWnXCnZ8QGo/vs85y3QIDAQAB";
    
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp
	public static String notify_url = "http://localhost:8889/alipay/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8889/alipay/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	//public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

