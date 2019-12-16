package com.example.demo.Controller;

import com.example.demo.Controller.viewObject.ShopVO;
import com.example.demo.error.BusinessException;
import com.example.demo.error.CommonError;
import com.example.demo.error.EmBusinessError;
import com.example.demo.respones.CommonReturnType;
import com.example.demo.service.ShopService;
import com.example.demo.service.impl.ShopServiceImpl;
import com.example.demo.service.model.ShopModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("shop")
@RequestMapping("/shop")
public class SelectShopController extends BaseController {

    @Autowired
    ShopService shopService;

    @RequestMapping("/getShop")
    @ResponseBody
    public CommonReturnType getShop(@RequestParam(name="id") int id) throws BusinessException {
        ShopModel shopModel = shopService.getShop(id);
        if (shopModel == null){
            throw new BusinessException(EmBusinessError.COMMON_ERROR);
        }
        ShopVO shopVO = converFromModel(shopModel);
        return CommonReturnType.create(shopVO);
    }

    @RequestMapping("/getShops")
    @ResponseBody
    public CommonReturnType getShop() throws BusinessException {
        List<ShopModel> shopModelList = shopService.getShops();
        return CommonReturnType.create(shopModelList);
    }



    private ShopVO converFromModel(ShopModel shopModel){
        if(shopModel == null){
            return null;
        }

        ShopVO shopVO = new ShopVO();
        BeanUtils.copyProperties(shopModel,shopVO);
        return shopVO;
    }
}
