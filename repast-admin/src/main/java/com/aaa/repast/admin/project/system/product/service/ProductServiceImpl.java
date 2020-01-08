package com.aaa.repast.admin.project.system.product.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.admin.project.system.product.domain.ProductVos;
import com.aaa.repast.common.support.Convert;
import com.sun.media.sound.RIFFInvalidDataException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import com.aaa.repast.admin.project.system.product.mapper.ProductMapper;
import com.aaa.repast.admin.project.system.product.domain.Product;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Service
public class ProductServiceImpl implements IProductService 
{
	@Autowired
	private ProductMapper productMapper;

	/**
     * 查询商品信息
     * 
     * @param id 商品ID
     * @return 商品信息
     */
    @Override
	public Product selectProductById(Long id)
	{
	    return productMapper.selectProductById(id);
	}
	
	/**
     * 查询商品列表
     * 
     * @param product 商品信息
     * @return 商品集合
     */
	@Override
	public List<Product> selectProductList(Product product)
	{
	    return productMapper.selectProductList(product);
	}
	
    /**
     * 新增商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	@Override
	public int insertProduct(Product product, MultipartFile file) {

		FtpProperties ftp = new FtpProperties();
		//获取上传图片的名字
		String oldName = file.getOriginalFilename();
		try {
			Random r = new Random();
			int ri = r.nextInt(1000);
			//生成新的文件名
			String newName= FileNameUtil.getFileName(Long.valueOf(ri));
			//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//获取文件的路径(2019/11/13)
			String filePath = new DateTime().toString("yyyy/MM/dd");

			String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
			product.setPic(headPic);
			product.setDeleteStatus(0);
			Integer i=  productMapper.insertProduct(product);
			//调用上传文件的工具类
			boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
					,file.getInputStream());
			if(i>0){
				return i;
			}


		}catch (Exception e){
				return  0;
		}
		return 0;
	}
	
	/**
     * 修改商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	@Override
	public int updateProduct(Product product)
	{
	    return productMapper.updateProduct(product);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductByIds(String ids)
	{
		return productMapper.deleteProductByIds(Convert.toStrArray(ids));
	}


	/**
	 * @Author Yang
	 * @Date Create in  2020/1/7 22:28
	 * @Description
	 * 查询商品 vo
	 */
	@Override
	public List<ProductVos> ProductVos(ProductVos productVo){
		List<ProductVos> productVos = productMapper.ProductVos(productVo);
		return productVos;
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 00:46
	 * @Description
	 * 根据id 查询商品的信息
	 */
	@Override
	public  Product findByIdProduct(Long id){
		return productMapper.findByIdProduct(id);
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 12:53
	 * @Description
	 * 修改商品信息
	 */
	@Override
	public Integer updateFindByIdProduct(Product product,MultipartFile file){
		FtpProperties ftp = new FtpProperties();
		//获取上传图片的名字
		String oldName = file.getOriginalFilename();
		try {
			String newName= FileNameUtil.getFileName(Long.valueOf(product.getId()));
			//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			//获取文件的路径(2019/11/13)
			String filePath = new DateTime().toString("yyyy/MM/dd");
			//调用上传文件的工具类
			boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
					,file.getInputStream());
			String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
			product.setPic(headPic);
		}catch (Exception e){

		}

			return productMapper.updateFindByIdProduct(product);

	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 14:31
	 * @Description
	 * 更改删除状态
	 */
	@Override
	public Integer deleteStatus(Long id,Integer status){
		return productMapper.deleteStatus(id,status);
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:24
	 * @Description
	 * 修改上下架状态
	 */
	@Override
	public Integer publishStatus( Long id, Integer status){
		return productMapper.publishStatus(id,status);
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 15:54
	 * @Description
	 * 更改 是否新品状态
	 */
	@Override
	public Integer newStatus( Long id, Integer status){
		return productMapper.newStatus(id,status);
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/8 19:11
	 * @Description
	 * 添加促销商品
	 */
	@Override
	public Integer promotionProduct(Long id , BigDecimal promotionPrice, String promotionStartTime, String promotionEndTime){
		return  productMapper.promotionProduct(id,promotionPrice,promotionStartTime,promotionEndTime);
	}
}
