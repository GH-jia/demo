package com.example.demo.service.impl;

import com.example.demo.dao.ShopDOMapper;
import com.example.demo.service.ShopService;
import com.example.demo.service.model.ShopModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDOMapper shopDOMapper;

    @Override
    public ShopModel getShop(int id) {
        ShopDO shopDO = new ShopDO();
        shopDO = shopDOMapper.selectByPrimaryKey(id);

        ShopModel shopModel = convertFromDO(shopDO);

        return shopModel;
    }

    @Override
    public List<ShopModel> getShops() {
        List<ShopDO> shopDOList = shopDOMapper.selectShops();
        List<ShopModel> shopModelList = shopDOList.stream().map(shopDO -> {
            ShopModel shopModel = this.convertFromDO(shopDO);
            return shopModel;
        }).collect(Collectors.toList());
        return shopModelList;
    }

    private ShopModel convertFromDO(ShopDO shopDO){
        if (shopDO == null){
            return null;
        }
        ShopModel shopModel = new ShopModel();
        BeanUtils.copyProperties(shopDO,shopModel);
        return shopModel;
    }
}
