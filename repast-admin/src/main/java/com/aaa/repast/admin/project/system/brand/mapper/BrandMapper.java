package com.aaa.repast.admin.project.system.brand.mapper;

import com.aaa.repast.admin.project.system.brand.domain.Brand;
import com.aaa.repast.admin.project.system.brand.Vo.BrandManagementVo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 品牌 数据层
 *
 * @author Seven Lee
 * @date 2019-12-28
 */
@Repository
public interface BrandMapper
{
	/**
	 * 查询品牌信息
	 *
	 * @param id 品牌ID
	 * @return 品牌信息
	 */
	public Brand selectBrandById(Long id);

	/**
	 * 查询品牌列表
	 *
	 * @param brand 品牌信息
	 * @return 品牌集合
	 */
	public List<Brand> selectBrandList(Brand brand);

	/**
	 * 新增品牌
	 *
	 * @param brand 品牌信息
	 * @return 结果
	 */
	public int insertBrand(Brand brand);

	/**
	 * 修改品牌
	 *
	 * @param brand 品牌信息
	 * @return 结果
	 */
	public int updateBrand(Brand brand);

	/**
	 * 删除品牌
	 *
	 * @param id 品牌ID
	 * @return 结果
	 */
	public int deleteBrandById(Long id);

	/**
	 * 批量删除品牌
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteBrandByIds(String[] ids);


	/**
	 * liyong
	 * 	查询品牌列表
	 */
	public List<BrandManagementVo> selectBrandAll(BrandManagementVo brandManagementVo);

	/**
	 * liyong
	 * 	修改是否显示状态
	 */
	public int showStatus(Long id,Integer show_status);


	/**
	 *    liyong
	 * 	是否为品牌制造商
	 */
	public int factoryStatus (Long id, Integer factory_status);

// 刘扬
	/**
	 * @Author Yang
	 * @Date Create in  2020/1/6 21:30
	 * @Description
	 *  查询品牌的id 和名字
	 */
	public List<Brand> selectBrand();


}