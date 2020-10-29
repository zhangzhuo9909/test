package org.zhangzhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.entity.Catalog;
import org.zhangzhuo.service.CatalogService;

import java.util.List;

@RestController
public class MallController {
    @Autowired
    private CatalogService catlogService;

    @GetMapping("catalogs/all")
    public ServiceResponse getCatalogsAll(Long pid){
        if (pid == null || pid.longValue() < 0){
            ServiceResponse.illegalArgs();
        }
        try {
            List<Catalog> list = catlogService.getCatalogsAll(pid);
            return ServiceResponse.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }
}
