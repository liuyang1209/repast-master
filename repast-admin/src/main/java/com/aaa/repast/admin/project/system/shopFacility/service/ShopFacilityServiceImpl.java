package com.aaa.repast.admin.project.system.shopFacility.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.shopFacility.mapper.ShopFacilityMapper;
import com.aaa.repast.admin.project.system.shopFacility.domain.ShopFacility;
import org.springframework.web.multipart.MultipartFile;

/**
 * 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-06
 */
@Service
public class ShopFacilityServiceImpl implements IShopFacilityService 
{
	@Autowired
	private ShopFacilityMapper shopFacilityMapper;

	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * 
     * @param id 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等ID
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     */
    @Override
	public ShopFacility selectShopFacilityById(Long id)
	{
	    return shopFacilityMapper.selectShopFacilityById(id);
	}
	
	/**
     * 查询店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等列表
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等集合
     */
	@Override
	public List<ShopFacility> selectShopFacilityList(ShopFacility shopFacility)
	{
	    return shopFacilityMapper.selectShopFacilityList(shopFacility);
	}
	
    /**
     * 新增店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	@Override
	public int insertShopFacility(ShopFacility shopFacility)
	{
		return shopFacilityMapper.insertShopFacility(shopFacility);
	}
	
	/**
     * 修改店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等
     * 
     * @param shopFacility 店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等信息
     * @return 结果
     */
	@Override
	public int updateShopFacility(ShopFacility shopFacility)
	{
	    return shopFacilityMapper.updateShopFacility(shopFacility);
	}

	/**
     * 删除店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopFacilityByIds(String ids)
	{
		return shopFacilityMapper.deleteShopFacilityByIds(Convert.toStrArray(ids));
	}

	@Override
	public Boolean addProductCategory(ShopFacility shopFacility, MultipartFile file) {
		FtpProperties ftp = new FtpProperties();
		// 如果id为null 或 "" 说明是添加
		if(shopFacility.getId()==null || "".equals(shopFacility.getId())){

			// 返回一级类目的主键
			Long id = shopFacilityMapper.returnId(shopFacility);
			if(id==null){
				return  false;
			}
			try {
				//获取上传图片的名字
				String oldName = file.getOriginalFilename();
				//生成新的文件名
				String newName= FileNameUtil.getFileName(Long.valueOf(shopFacility.getId()));
				//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				//获取文件的路径(2019/11/13)
				String filePath = new DateTime().toString("yyyy/MM/dd");
				//调用上传文件的工具类
				boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
						,file.getInputStream());
				if(ifSuccess){
					String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
					Integer result = shopFacilityMapper.getIcon(headPic, shopFacility.getId());
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
				Integer result = shopFacilityMapper.updateShopFacility(shopFacility);
				if(result>0){
					return true;
				}
			}else {
				try {
					//生成新的文件名
					String newName= FileNameUtil.getFileName(Long.valueOf(shopFacility.getId()));
					//截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
					newName = newName + oldName.substring(oldName.lastIndexOf("."));
					//获取文件的路径(2019/11/13)
					String filePath = new DateTime().toString("yyyy/MM/dd");
					//调用上传文件的工具类
					boolean ifSuccess =	FtpUtil.uploadFile(ftp.getIpAddr(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newName
							,file.getInputStream());

					if(ifSuccess){
						String headPic= ftp.getHttpPath()+"/"+filePath+"/"+newName;
						shopFacility.setIcon(headPic);
						Integer integer = shopFacilityMapper.updateShopFacility(shopFacility);
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

}
