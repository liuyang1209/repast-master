package com.aaa.repast.admin.project.system.brand.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.admin.project.system.brand.Vo.BrandManagementVo;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import com.aaa.repast.admin.project.system.brand.mapper.BrandMapper;
import com.aaa.repast.admin.project.system.brand.domain.Brand;
import org.springframework.web.multipart.MultipartFile;

/**
 * 品牌 服务层实现
 *
 * @author Seven Lee
 * @date 2019-12-28
 */
@Service
public class BrandServiceImpl implements IBrandService {
    /*注入图片上传的配置类、组件*/
    @Autowired
    private FtpProperties ftpProperties;
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询品牌信息
     *
     * @param id 品牌ID
     * @return 品牌信息
     */
    @Override
    public Brand selectBrandById(Long id) {
        return brandMapper.selectBrandById(id);
    }

    /**
     * 查询品牌列表
     *
     * @param brand 品牌信息
     * @return 品牌集合
     */
    @Override
    public List<Brand> selectBrandList(Brand brand) {
        return brandMapper.selectBrandList(brand);
    }

    /**
     * 新增品牌
     *
     * @param brand 品牌信息
     * @return 结果
     */
    @Override
    public int insertBrand(MultipartFile[] files, Brand brand) {


        int i = 1;
        for (
                MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            if (null == oldName || ("").equals(oldName)) {

                i++;
                continue;
            }
            try {
                String newName = FileNameUtil.getFileName(Long.valueOf(brand.getSort()));
                newName = newName + oldName.substring(oldName.lastIndexOf("."));
                String filePath = new DateTime().toString("yyyy/MM/dd");

                boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
                        ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
                if (ifSuccess) {
                    String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                    if (i == 1) {
                        brand.setLogo(headPic);
                    } else if (i == 2) {
                        brand.setBigPic(headPic);
                    }
                    i++;
                } else {
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return brandMapper.insertBrand(brand);
    }

    /**
     * 修改品牌
     *
     * @param brand 品牌信息
     * @return 结果
     */
    @Override
    public int updateBrand(MultipartFile[] files, Brand brand) {
        int i = 1;
		for (
				MultipartFile file : files) {
			String oldName = file.getOriginalFilename();
			if (null == oldName || ("").equals(oldName)) {
                i++;
                continue;
			}
			try {
				String newName = FileNameUtil.getFileName(Long.valueOf(brand.getSort()));
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				String filePath = new DateTime().toString("yyyy/MM/dd");

				boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
						ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
				if (ifSuccess) {
					String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                    if (i == 1) {
                        brand.setLogo(headPic);
                    } else if (i == 2) {
                        brand.setBigPic(headPic);
                    }
                    i++;

				} else {
					return 0;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return brandMapper.updateBrand(brand);
	}



    /**
     * 删除品牌对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBrandByIds(String ids) {
        return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
    }





    /**
     * liyong
     * 查询品牌列表
     */
    @Override
    public List<BrandManagementVo> selectBrandAll(BrandManagementVo brandManagementVo) {
        return brandMapper.selectBrandAll(brandManagementVo);
    }

    /**
     * liyong
     * 修改是否显示状态
     *
     */
    @Override
    public int showStatus(Long id, Integer show_status) {
        if (show_status == 1) {
            show_status = 0;
        } else if (show_status == 0) {
            show_status = 1;
        }
        return brandMapper.showStatus(id, show_status);
    }


    /**
     * liyong
     * 是否为品牌制造商
     *
     */
    @Override
    public int factoryStatus(Long id, Integer factory_status) {
        if (factory_status == 1) {
            factory_status = 0;
        } else if (factory_status == 0) {
            factory_status = 1;
        }
        return brandMapper.factoryStatus(id, factory_status);
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
