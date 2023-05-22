# 电脑商城项目

## 介绍

使用 SpringBoot + MyBatis + MySQL + AOP 技术栈编写前后端不分离的电脑商城项目，主要功能有用户登录、注册，修改密码、个人资料，上传头像，收货地址显示（添加、删除、设置默认），商品详情展示，购物车列表显示（增加、删除商品），创建订单等。

## 相关模块

### 1、用户模块 IUserService  
:star2: 用户注册：  void register(User user);  
:star2: 用户登录：  User login(String username, String password);  
:star2: 修改用户密码：  void changePassword(Integer uid, String username, String oldPassword, String newPassword);  
:star2: 获取用户信息：  User getByUid(Integer uid);  
:star2: 修改用户信息（手机号、邮箱、性别）：  void changeInfo(Integer uid, String username, User user);  
:star2: 修改用户头像：  void changeAvatar(Integer uid, String avatar, String username);

### 2、地区模块 IDistrictService  
:star2: 获取全国所有省/某省所有市/某市所有区：  `List<District> getByParent(String parent);`  
:star2: 根据省/市/区的行政代号获取省/市/区的名称：  String getNameByCode(String code);

### 3、地址模块 IAddressService  
:star2: 添加收获地址：  void addNewAddress(Integer uid, String username, Address address);  
:star2: 根据用户 id 获取收货地址列表：  `List<Address> getByUid(Integer uid);`  
:star2: 设置默认收货地址:  void setDefault(Integer aid, Integer uid, String username);  
:star2: 删除收货地址:  void delete(Integer aid, Integer uid, String username);  
:star2: 根据地址 id 获取收货地址:  Address getByAid(Integer aid, Integer uid);  

### 4、商品模块 IProductService  
:star2: 显示热销商品前四位:  `List<Product> findHotList();`  
:star2: 根据商品 id 查询商品信息:  Product findById(Integer id);

### 5、购物车模块 ICartService  
:star2: 将商品添加到购物车:  void addToCart(Integer uid, Integer pid, Integer amount, String username);  
:star2: 查询某用户的购物车数据:  `List<CartVO> getVOByUid(Integer uid);`  
:star2: 将购物车中某商品的数量加1:  Integer addNum(Integer cid, Integer uid, String username);  
:star2: 将购物车中某商品的数量减1:  Integer reduceNum(Integer cid, Integer uid, String username);  
:star2: 根据若干个购物车数据id查询详情的列表:  `List<CartVO> getVOByCid(Integer uid, Integer[] cid);`  

### 6、订单模块 IOrderService  
:star2: 创建订单:  Order create(Integer aid, Integer[] cid, Integer uid, String username);