package com.demo.factory;

import com.demo.strategy.ProductStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("productFactory")
public class ProductFactory {

    @Resource
    private List<ProductStrategy> list;

    public ProductStrategy getProductStrategy(Integer type, Integer oldProduct){
        for (ProductStrategy productStrategy : list) {
            if(productStrategy.isSupport(type, oldProduct)){
                return productStrategy;
            }
        }
        return null;
    }

}
