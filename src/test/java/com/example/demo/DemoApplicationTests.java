package com.example.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demo.dataObject.ShopDO;
import com.example.demo.dataObject.cache.RedisDO;
import com.example.demo.service.ShopService;
import com.example.demo.service.model.ShopModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();
    }


    private RedisDO redisDO = new RedisDO();
    @Autowired
    private ShopService shopService;

    @Test
    public void redisDOTest(){
        int id = 1;
        ShopDO shopDO = redisDO.getShopDO(id);
        if (shopDO == null){
            ShopModel shopModel = shopService.getShop(id);
            if (shopModel != null){
                BeanUtils.copyProperties(shopModel,shopDO);

                String result = redisDO.putShopDO(shopDO);
                System.out.println(result);
                ShopDO shopDO1 = redisDO.getShopDO(id);
                System.out.println(shopDO1);
            }


        }
    }



}
