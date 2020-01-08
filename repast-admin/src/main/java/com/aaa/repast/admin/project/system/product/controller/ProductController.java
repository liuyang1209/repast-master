package com.aaa.repast.admin.project.system.product.controller;

import java.math.BigDecimal;
import java.net.Proxy;
import java.util.List;
import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.brand.domain.Brand;
import com.aaa.repast.admin.project.system.brand.service.IBrandService;
import com.aaa.repast.admin.project.system.product.domain.ProductVos;
import com.aaa.repast.admin.project.system.productAttribute.domain.ProductAttribute;
import com.aaa.repast.admin.project.system.productAttribute.service.IProductAttributeService;
import com.aaa.repast.admin.project.system.productAttributeCategory.domain.ProductAttributeCategory;
import com.aaa.repast.admin.project.system.productAttributeCategory.service.IProductAttributeCategoryService;
import com.aaa.repast.admin.project.system.productCategory.domain.ProductCategory;
import com.aaa.repast.admin.project.system.productCategory.service.IProductCategoryService;
import com.aaa.repast.admin.project.system.shopFacility.service.IShopFacilityService;
import com.aaa.repast.admin.project.system.shopFacility.service.ShopFacilityServiceImpl;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import com.aaa.repast.admin.project.system.shopInformation.service.IShopInformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.repast.admin.project.system.product.domain.Product;
import com.aaa.repast.admin.project.system.product.service.IProductService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品 信息操作处理
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Controller
@RequestMapping("/system/product")
public class ProductController extends BaseController
{
    private String prefix = "system/product";

	@Autowired
	private IProductService productService;

	@Autowired
	private IShopInformationService shopInformation;

	@Autowired
	private IBrandService brandService;

	@Autowired
	private IProductCategoryService productCategoryService;

	@Autowired
	private IProductAttributeCategoryService  categoryService;

	@Autowired
	private  IProductAttributeService productAttributeService;
	
	@RequiresPermissions("system:product:view")
	@GetMapping()
	public String product()
	{
	    return prefix + "/product";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("system:product:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductVos productVos)
	{
		startPage();
        //List<Product> list = productService.selectProductList(product);
		List<ProductVos> productVo = productService.ProductVos(productVos);
		return getDataTable(productVo);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("system:product:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Product product)
    {
    	List<Product> list = productService.selectProductList(product);
        ExcelUtil<Product> util = new ExcelUtil<Product>(Product.class);
        return util.exportExcel(list, "product");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("system:product:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Product product, MultipartFile file)
	{
		return toAjax(productService.insertProduct(product,file));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Product product = productService.selectProductById(id);
		mmap.put("product", product);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("system:product:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Product product)
	{		
		return toAjax(productService.updateProduct(product));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("system:product:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productService.deleteProductByIds(ids));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 20:54
	 * @Description
	 *  查询店铺信息
	 */
	@RequiresPermissions("system:product:selectProduct")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@GetMapping( "/selectProduct")
	@ResponseBody
	public List<ShopInformation> selectProduct(String ids)
	{

		return shopInformation.getShopinformation();
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:36
	 * @Description
	 * 查询品牌id 和 名字
	 */
	@RequiresPermissions("system:product:selectBrand")
	@Log(title = "查询品牌id 和 名字 ", businessType = BusinessType.DELETE)
	@GetMapping( "/selectBrand")
	@ResponseBody
	public List<Brand> selectProduct()
	{
		return brandService.selectBrand();
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:36
	 * @Description
	 * 查询分类 id 和 名字
	 */
	@RequiresPermissions("system:product:selectProductCategory")
	@Log(title = "查询品牌id 和 名字 ", businessType = BusinessType.DELETE)
	@GetMapping( "/selectProductCategory")
	@ResponseBody
	public List<ProductCategory> selectProductCategory()
	{
		return productCategoryService.selectTwoProduct();
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:36
	 * @Description
	 * 查询分类 id 和 名字
	 */
	@RequiresPermissions("system:product:selectProductAttributeCategory")
	@Log(title = "查询商品属性id 和 名字 ", businessType = BusinessType.DELETE)
	@GetMapping( "/selectProductAttributeCategory")
	@ResponseBody
	public List<ProductAttributeCategory> selectProductAttribute()
	{

		return categoryService.selectProductAttribute();
	}
	/**
	 * @Author Yang
 	* @Date Create in  2020/1/7 13:21
 	* @Description
 	* 	根据商品类型 查询商品属性
 	*/
	@RequiresPermissions("system:product:selectAttributeByType")
	@Log(title = "查询商品属性id 和 名字 ", businessType = BusinessType.DELETE)
	@PostMapping( "/selectAttributeByType")
	@ResponseBody
	public List<ProductAttribute> selectProductAttribute(Integer type) {
		return productAttributeService.selectAttributeByType(type);
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/7 22:26
	 * @Description
	 * 查询  商品vo
	 */
	@RequiresPermissions("system:product:ProductVos")
	@Log(title = "查询商品属性id 和 名字 ", businessType = BusinessType.DELETE)
	@PostMapping( "/ProductVos")
	@ResponseBody
	public TableDataInfo ProductVos(ProductVos productVos) {
		startPage();
		List<ProductVos> productVo = productService.ProductVos(productVos);
		return getDataTable(productVo);
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 00:46
	 * @Description
	 * 根据id 查询商品的信息
	 */
	@RequiresPermissions("system:product:findByIdProduct")
	@Log(title = "根据id 查询商品的信息 ", businessType = BusinessType.DELETE)
	@PostMapping( "/findByIdProduct")
	@ResponseBody
	public  Product findByIdProduct(Long id){
		return productService.findByIdProduct(id);
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 11:29
	 * @Description
	 *  修改商品信息
	 */
	@RequiresPermissions("system:product:updateFindByIdProduct")
	@Log(title = "修改商品信息 ", businessType = BusinessType.DELETE)
	@PostMapping( "/updateFindByIdProduct")
	@ResponseBody
	public 	Integer updateFindByIdProduct(Product product,MultipartFile file){

		return productService.updateFindByIdProduct(product,file);
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:00
	 * @Description
	 * 修改删除状态
	 */
	@RequiresPermissions("system:product:status")
	@Log(title = "修改删除状态 ", businessType = BusinessType.DELETE)
	@PostMapping( "/status")
	@ResponseBody
	public  AjaxResult status(Long id, Integer status){
		return toAjax(productService.deleteStatus(id,status));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:18
	 * @Description
	 *  修改上下架状态
	 */
	@RequiresPermissions("system:product:publishStatus")
	@Log(title = "修改删除状态 ", businessType = BusinessType.DELETE)
	@PostMapping( "/publishStatus")
	@ResponseBody
	public  AjaxResult publishStatus(Long id, Integer status){
		return toAjax(productService.publishStatus(id,status));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:45
	 * @Description
	 * 更改新品状态
	 */
	@RequiresPermissions("system:product:newStatus")
	@Log(title = "修改删除状态 ", businessType = BusinessType.DELETE)
	@PostMapping( "/newStatus")
	@ResponseBody
	public  AjaxResult newStatus(Long id, Integer status){
		return toAjax(productService.newStatus(id,status));
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:04
	 * @Description
	 *  商品的特惠促销方法
	 */
	@RequiresPermissions("system:product:promotionProduct")
	@Log(title = "商品的特惠促销方法 ", businessType = BusinessType.DELETE)
	@PostMapping( "/promotionProduct")
	@ResponseBody
	public AjaxResult promotionProduct(Long id ,BigDecimal promotionPrice,String promotionStartTime, String promotionEndTime){
		return toAjax(productService.promotionProduct(id,promotionPrice,promotionStartTime,promotionEndTime));
	}
}
