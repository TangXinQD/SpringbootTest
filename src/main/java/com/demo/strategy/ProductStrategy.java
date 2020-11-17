package com.demo.strategy;

import java.util.List;

/**
 * @author TX
 * 产品策略抽象
 */
public interface ProductStrategy {

    /**
     * @description  策略是否支持
     * @version 1.0
     * @date 2020/11/17 22:09
     * @author TX
     *
     * @param type 产品类型
     * @param oldProduct 是否是老产品
     * @return
     **/
    boolean isSupport(Integer type, Integer oldProduct);

    /**
     * @description  创建sku
     * @version 1.0
     * @date 2020/11/17 22:13
     * @author TX
     *
     * @param object 产品dto
     * @return List<Object> 返回sku
     **/
    List<Object> buildSku(Object object);

}
