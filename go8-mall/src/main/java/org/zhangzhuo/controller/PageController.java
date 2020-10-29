package org.zhangzhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhangzhuo.config.SearchResult;
import org.zhangzhuo.entity.IndexRoll;
import org.zhangzhuo.entity.ProductDetail;
import org.zhangzhuo.entity.ProductExe;
import org.zhangzhuo.entity.ProductSku;
import org.zhangzhuo.pojo.*;
import org.zhangzhuo.service.*;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private IndexRollService indexRollService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private ProductService productService;

    /**
     * 默认界面
     * @return
     */
    @GetMapping("/")
    public String defaultPage(){
        return "forward:/index.html";
    }
    /**
     * 展示轮播图
     * @param model
     * @return
     */
    @GetMapping("/index.html")
    public String index(Model model){
        List<IndexRoll> list = indexRollService.getIndexRoll();
        model.addAttribute("rolls",list);
        return "index";
    }
    /**
     * 按条件查询并分页
     * @param q
     * @param page
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/list.html")
    public String searchQuery(@RequestParam("q") String q, @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "30") int size, Model model){
        SearchResult<Product> sd = searchService.queryMath(q, page, size);
        model.addAttribute("sd",sd);
        return "list";
    }


    /**
     * 加载详情页
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/product.html")
    public String getIndex(Long id ,Model model){
        ProductExe product =  productService.getProductBrandById(id);
        ProductDetail productDetail = productService.getProductDetailById(id);
        List<ProductSku> skuList = productService.getProductSkulById(id);

        model.addAttribute("product",product);
        model.addAttribute("detail",productDetail);
        model.addAttribute("skus",skuList);
        return "product";
    }

    /**
     * 成功页面
     * @param id
     * @param title
     * @param model
     * @return
     */
    @GetMapping("/cartSuccess.html")
    public String cartSuccess(long id, String title, Model model) {
        model.addAttribute("title", title);
        return "cartSuccess";
    }

    /**
     * 下单页面
     * @return
     */
    @GetMapping("/order.html")
    public String order(){
        return "order";
    }

    /**
     *注册
     * @return
     */
    @GetMapping("/login.html")
    public String getLogin(Model model,String returnUrl){
        model.addAttribute("returnUrl",returnUrl);
        return "login";
    }

    /**
     * 登录
     * @param model
     * @param returnUrl
     * @return
     */
    @GetMapping("/register.html")
    public String getRegister(Model model,String returnUrl){
        model.addAttribute("returnUrl",returnUrl);
        return "register";
    }

    @GetMapping("/member.html")
    public String member() {
        return "member";
    }
}
