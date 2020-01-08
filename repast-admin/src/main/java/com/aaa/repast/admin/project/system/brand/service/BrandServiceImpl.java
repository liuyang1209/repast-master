package com.aaa.repast.admin.project.system.brand.service;

import com.aaa.repast.admin.project.system.brand.vo.BrandManagementVo;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.aaa.repast.admin.project.system.brand.mapper.BrandMapper;
import com.aaa.repast.admin.project.system.brand.domain.Brand;

/**
 * 品牌 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Service
public class BrandServiceImpl implements IBrandService 
{
	@Autowired
	private BrandMapper brandMapper;

	/**
     * 查询品牌信息
     * 
     * @param id 品牌ID
     * @return 品牌信息
     */
    @Override
	public Brand selectBrandById(Long id)
	{
	    return brandMapper.selectBrandById(id);
	}
	
	/**
     * 查询品牌列表
     * 
     * @param brand 品牌信息
     * @return 品牌集合
     */
	@Override
	public List<Brand> selectBrandList(Brand brand)
	{
	    return brandMapper.selectBrandList(brand);
	}
	
    /**
     * 新增品牌
     * 
     * @param brand 品牌信息
     * @return 结果
	 */
	@Override
	public int insertBrand(Brand brand)
	{
	    return brandMapper.insertBrand(brand);
	}
	
	/**
     * 修改品牌
     * 
     * @param brand 品牌信息
     * @return 结果
     */
	@Override
	public int updateBrand(Brand brand)
	{
	    return brandMapper.updateBrand(brand);
	}

	/**
     * 删除品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBrandByIds(String ids)
	{
		return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
	}




	/**
	 *liyong
	 */
	@Override
	public List<BrandManagementVo> selectBrandAll(BrandManagementVo brandManagementVo) {
		return brandMapper.selectBrandAll(brandManagementVo);
	}

	// 刘扬
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:30
	 * @Description
	 *  查询品牌的id 和名字
	 */
	@Override
	public List<Brand> selectBrand(){
		return brandMapper.selectBrand();
	}
}
