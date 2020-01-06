package com.aaa.repast.admin.project.system.productCategory.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

import com.aaa.repast.admin.project.system.productCategory.mapper.ProductCategoryMapper;
import com.aaa.repast.admin.project.system.productCategory.domain.ProductCategory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品分类 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService 
{
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	/**
     * 查询产品分类信息
     * 
     * @param id 产品分类ID
     * @return 产品分类信息
     */
    @Override
	public ProductCategory selectProductCategoryById(Long id)
	{
	    return productCategoryMapper.selectProductCategoryById(id);
	}
	
	/**
     * 查询产品分类列表
     * 
     * @param productCategory 产品分类信息
     * @return 产品分类集合
     */
	@Override
	public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory)
	{
	    return productCategoryMapper.selectProductCategoryList(productCategory);
	}
	
    /**
     * 新增产品分类
     * 
     * @param productCategory 产品分类信息
     * @return 结果
     */
	@Override
	public int insertProductCategory(ProductCategory productCategory)
	{
	    return productCategoryMapper.insertProductCategory(productCategory);
	}
	
	/**
     * 修改产品分类
     * 
     * @param productCategory 产品分类信息
     * @return 结果
     */
	@Override
	public int updateProductCategory(ProductCategory productCategory)
	{
	    return productCategoryMapper.updateProductCategory(productCategory);
	}

	/**
     * 删除产品分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductCategoryByIds(String ids)
	{
		return productCategoryMapper.deleteProductCategoryByIds(Convert.toStrArray(ids));
	}
	//添加的方法
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 21:03
	 * @Description
	 * 添加一级类目
	 */
	@Override
	public Boolean addProductCategory(ProductCategory productCategory, MultipartFile file) {
		FtpProperties ftp = new FtpProperties();
		// 如果id为null 或 "" 说明是添加
		if(productCategory.getId()==null || "".equals(productCategory.getId())){

			// 返回一级类目的主键
			Long id = productCategoryMapper.returnId(productCategory);
			if(id==null){
				return  false;
			}
			try {
				//获取上传图片的名字
				String oldName = file.getOriginalFilename();
				//生成新的文件名
				String newName= FileNameUtil.getFileName(Long.valueOf(productCategory.getId()));
				//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				//获取文件的路径(2019/11/13)
				String filePath = new DateTime().toString("yyyy/MM/dd");
				//调用上传文件的工具类
				boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
						,file.getInputStream());
				if(ifSuccess){
					String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
					Integer result = productCategoryMapper.getIcon(headPic, productCategory.getId());
					if(result>0){
						return true;
					}
				}else {
					return  false;
				}
			}catch (Exception e){

			}

		}else{
			// 否则为修改
			//获取上传图片的名字
			String oldName = file.getOriginalFilename();
			if("".equals(oldName) || null==oldName ){
				Integer result = productCategoryMapper.updateTwoInfo(productCategory);
				if(result>0){
					return true;
				}
			}else {
				try {
					//生成新的文件名
					String newName= FileNameUtil.getFileName(Long.valueOf(productCategory.getId()));
					//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
					newName = newName + oldName.substring(oldName.lastIndexOf("."));
					//获取文件的路径(2019/11/13)
					String filePath = new DateTime().toString("yyyy/MM/dd");
					//调用上传文件的工具类
					boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
							,file.getInputStream());

					if(ifSuccess){
						String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
						productCategory.setIcon(headPic);
						Integer integer = productCategoryMapper.updateTwoInfoAndImage(productCategory);
						if(integer>0){
							return true;
						}
					}
				}catch (Exception e){

				}
			}
		}

		return false;
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/2 20:40
	 * @Description
	 * 根据一级类目的id 查询二级类目的商品信息
	 */
	@Override
	public List<ProductCategory> selectTow(Long id) {
		List<ProductCategory> p = productCategoryMapper.selectTow(id);
		if(null !=p){
			return  p;
		}
		return null;
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 18:52
	 * @Description
	 *  修改二级类目信息
	 */
	@Override
	public Boolean twoInfo(ProductCategory productCategory, MultipartFile file) {
		FtpProperties ftp = new FtpProperties();
		//获取上传图片的名字
		String oldName = file.getOriginalFilename();
		if("".equals(oldName) || null==oldName ){
			Integer result = productCategoryMapper.updateTwoInfo(productCategory);
			if(result>0){
				return true;
			}
		}else{
			try {
				//生成新的文件名
				String newName= FileNameUtil.getFileName(Long.valueOf(productCategory.getId()));
				//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				//获取文件的路径(2019/11/13)
				String filePath = new DateTime().toString("yyyy/MM/dd");
				//调用上传文件的工具类
				boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
						,file.getInputStream());

				if(ifSuccess){
					String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
					productCategory.setIcon(headPic);
					Integer integer = productCategoryMapper.updateTwoInfoAndImage(productCategory);
					if(integer>0){
						return true;
					}
				}
			}catch (Exception e){

			}
		}
		return false;
	}
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/3 19:35
	 * @Description
	 * 删除（修改状态）一级类目
	 */
	@Override
	public Boolean delTwoStatus(Long id) {
		Integer result = productCategoryMapper.delTwoStatus(id);
		if(result>0){
			return true;
		}
		return false;
	}

	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 09:45
	 * @Description
	 *  添加二级类目
	 */
	@Override
	public Boolean twoProinfo(ProductCategory productCategory,MultipartFile file) {
		FtpProperties ftp = new FtpProperties();
		//获取上传图片的名字
		String oldName = file.getOriginalFilename();
		Random r = new Random();
		int i = r.nextInt(1000);
		try {
		//生成新的文件名
		String newName= FileNameUtil.getFileName(Long.valueOf(i));
		//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
		newName = newName + oldName.substring(oldName.lastIndexOf("."));
		//获取文件的路径(2019/11/13)
		String filePath = new DateTime().toString("yyyy/MM/dd");
		//调用上传文件的工具类
		boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
				,file.getInputStream());

		if(ifSuccess){
			String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
			productCategory.setIcon(headPic);
			Integer integer = productCategoryMapper.twoProinfo(productCategory);
			if(integer>0){
				return true;
			}
		}
	}catch (Exception e){

}
		return false;
	}

}
