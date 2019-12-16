package com.example.demo.service;

import com.example.demo.service.model.ShopModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopService {
    public ShopModel getShop(int id);
    public List<ShopModel> getShops();
}
