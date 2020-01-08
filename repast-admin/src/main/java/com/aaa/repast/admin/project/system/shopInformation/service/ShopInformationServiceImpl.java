package com.aaa.repast.admin.project.system.shopInformation.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.common.support.Convert;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import com.aaa.repast.admin.project.system.shopInformation.mapper.ShopInformationMapper;
import com.aaa.repast.admin.project.system.shopInformation.domain.ShopInformation;
import org.springframework.web.multipart.MultipartFile;

/**
 * 店铺的基本 服务层实现
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Service
public class ShopInformationServiceImpl implements IShopInformationService {
    @Autowired
    private ShopInformationMapper shopInformationMapper;
    @Autowired
    private FtpProperties ftpProperties;

    /**
     * 查询店铺的基本信息
     *
     * @param id 店铺的基本ID
     * @return 店铺的基本信息
     */
    @Override
    public ShopInformation selectShopInformationById(Long id) {
        return shopInformationMapper.selectShopInformationById(id);
    }

    /**
     * 查询店铺的基本列表
     *
     * @param shopInformation 店铺的基本信息
     * @return 店铺的基本集合
     */
    @Override
    public List<ShopInformation> selectShopInformationList(ShopInformation shopInformation) {
        return shopInformationMapper.selectShopInformationList(shopInformation);
    }

    /**
     * 新增店铺的基本
     *
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
    @Override
    public int insertShopInformation(MultipartFile[] files, ShopInformation shopInformation) {
        int i = 1;
        for (
                MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            if (null == oldName || ("").equals(oldName)) {

                i++;
                continue;
            }
            try {
                String newName = FileNameUtil.getFileName(shopInformation.getOwnerId());
                newName = newName + oldName.substring(oldName.lastIndexOf("."));
                String filePath = new DateTime().toString("yyyy/MM/dd");

                boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
                        ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
                if (ifSuccess) {
                    String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                    if (i == 1) {
                        shopInformation.setImages(headPic);
                    } else if (i == 2) {
                        shopInformation.setBusinessLicense(headPic);
                    } else if (i == 3) {
                        shopInformation.setFoodLicense(headPic);
                    } else if (i == 4) {
                        shopInformation.setSanitationLicense(headPic);
                    } else if (i == 5) {
                        shopInformation.setAssess(headPic);
                    }
                    i++;
                } else {
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return shopInformationMapper.insertShopInformation(shopInformation);
    }

    /**
     * 修改店铺的基本
     *
     * @param shopInformation 店铺的基本信息
     * @return 结果
     */
    @Override
    public int updateShopInformation(MultipartFile[] files, ShopInformation shopInformation) {
        int i = 1;
        for (
                MultipartFile file : files) {
            String oldName = file.getOriginalFilename();
            if (null == oldName || ("").equals(oldName)) {

                i++;
                continue;
            }
            try {
                String newName = FileNameUtil.getFileName(shopInformation.getOwnerId());
                newName = newName + oldName.substring(oldName.lastIndexOf("."));
                String filePath = new DateTime().toString("yyyy/MM/dd");

                boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
                        ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
                if (ifSuccess) {
                    String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                    if (i == 1) {
                        shopInformation.setImages(headPic);
                    } else if (i == 2) {
                        shopInformation.setBusinessLicense(headPic);
                    } else if (i == 3) {
                        shopInformation.setFoodLicense(headPic);
                    } else if (i == 4) {
                        shopInformation.setSanitationLicense(headPic);
                    } else if (i == 5) {
                        shopInformation.setAssess(headPic);
                    }
                    i++;
                } else {
                    return 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return shopInformationMapper.updateShopInformation(shopInformation);
    }

    /**
     * 删除店铺的基本对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShopInformationByIds(String ids) {
        return shopInformationMapper.deleteShopInformationByIds(Convert.toStrArray(ids));
    }

    /**
     * 查询店铺的名称信息
     *
     * @return 店铺的名称信息
     */
    @Override
    public List<ShopInformation> selectShopInformationName() {
        List<ShopInformation> shopInformations = shopInformationMapper.selectShopInformationName();
        return shopInformations;
    }

    /**
     * 修改营业状态
     *
     * @param id
     * @param closed
     * @return
     */

    @Override
    public int updateClosed(Long id, Integer closed) {
        if (closed == 0) {
            closed = 1;
        } else if (closed == 1) {
            closed = 0;
        }
        return shopInformationMapper.updateClosed(id, closed);
    }

  /*  public int updateClosed(ShopInformation shopInformation){
        String dateTime = new DateTime().toString("HH:MM");
        List<ShopInformation> shopInformations = shopInformationMapper.selectShopInformationList(shopInformation);
        for (ShopInformation shopInformationClosed : shopInformations){
            if ()
        }

    }*/

    // 刘扬写的代码：
    /**
     * @Author Yang
     * @Date Create in  2020/1/6 20:23
     * @Description
     * 查询所有的店铺
     */
    @Override
    public List<ShopInformation> getShopinformation(){
        return  shopInformationMapper.getShopinformation();
    }


    //董彤彤
    /**
     * 查询店铺的名称信息
     * @return 店铺的名称信息
     */
    @Override
    public List<ShopInformation> selectShopInformationNames() {
        List<ShopInformation> shopInformations = shopInformationMapper.selectShopInformationNames();
        return shopInformations;
    }

}
