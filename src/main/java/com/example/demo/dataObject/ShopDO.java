package com.example.demo.dataObject;

public class ShopDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.id
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.shop_name
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    private String shopName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.telphone
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    private String telphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shop.code
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    private String code;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.id
     *
     * @return the value of shop.id
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.id
     *
     * @param id the value for shop.id
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.shop_name
     *
     * @return the value of shop.shop_name
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.shop_name
     *
     * @param shopName the value for shop.shop_name
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.telphone
     *
     * @return the value of shop.telphone
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.telphone
     *
     * @param telphone the value for shop.telphone
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shop.code
     *
     * @return the value of shop.code
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shop.code
     *
     * @param code the value for shop.code
     *
     * @mbg.generated Fri Nov 22 21:11:07 CST 2019
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}