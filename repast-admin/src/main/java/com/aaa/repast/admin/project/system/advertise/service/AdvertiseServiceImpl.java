package com.aaa.repast.admin.project.system.advertise.service;

import com.aaa.repast.admin.framework.ftp.FileNameUtil;
import com.aaa.repast.admin.framework.ftp.FtpProperties;
import com.aaa.repast.admin.framework.ftp.FtpUtil;
import com.aaa.repast.admin.project.system.advertise.domain.AdvertiseAndPositionVo;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aaa.repast.admin.project.system.advertise.mapper.AdvertiseMapper;
import com.aaa.repast.admin.project.system.advertise.domain.Advertise;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * 广告位 服务层实现
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Service
public class AdvertiseServiceImpl implements IAdvertiseService {
    @Autowired
    private AdvertiseMapper advertiseMapper;
    @Autowired
    private FtpProperties ftpProperties;

    /**
     * 查询广告位信息
     *
     * @param id 广告位ID
     * @return 广告位信息
     */
    @Override
    public AdvertiseAndPositionVo selectAdvertiseById(Long id) {
        return advertiseMapper.selectAdvertiseById(id);
    }

    /**
     * 查询广告位列表
     *
     * @param advertiseAndPositionVo 广告位信息
     * @return 广告位集合
     */
    @Override
    public List<AdvertiseAndPositionVo> selectAdvertiseList(AdvertiseAndPositionVo advertiseAndPositionVo) {
        return advertiseMapper.selectAdvertiseList(advertiseAndPositionVo);
    }

    /**
     * 新增广告位
     *
     * @param advertise 广告位信息
     * @return 结果
     */
    @Override
    public int insertAdvertise(MultipartFile file, Advertise advertise) {
        String oldName = file.getOriginalFilename();
        try {
                   /* Fuser user = (Fuser) session.getAttribute("user");

                    String newName = FileNameUtil.getFileName(user.getId());*/
            String newName = FileNameUtil.getFileName(advertise.getPositionId());
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            String filePath = new DateTime().toString("yyyy/MM/dd");

            boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
            if (ifSuccess) {
                String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                advertise.setPic(headPic);
                advertise.setDelStatus(1);
                // Integer updateResult = fuserMapper.updateHeadPicById(fuser);
                Integer insertResult = advertiseMapper.insertAdvertise(advertise);
                if (insertResult > 0) {
                    return insertResult;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 修改广告位
     *
     * @param advertise 广告位信息
     * @return 结果
     */
    @Override
    public int updateAdvertise(MultipartFile file, Advertise advertise) {

        String oldName = file.getOriginalFilename();
        if (null == oldName || ("").equals(oldName)) {
            return advertiseMapper.updateAdvertise(advertise);
        }
        try {
            String newName = FileNameUtil.getFileName(advertise.getPositionId());
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            String filePath = new DateTime().toString("yyyy/MM/dd");

            boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
            if (ifSuccess) {
                String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                advertise.setPic(headPic);
                advertise.setDelStatus(1);
                Integer insertResult = advertiseMapper.updateAdvertise(advertise);
                if (insertResult > 0) {
                    return insertResult;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  } else {
            return advertiseMapper.updateAdvertise(advertise);
        }*/
        return 0;
    }

    /**
     * 删除广告位对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAdvertiseByIds(String ids) {
        /* String[] id = Convert.toStrArray(ids);*/
        int i = 0;
        for (String id : Convert.toStrArray(ids)) {
            i = advertiseMapper.deleteAdvertiseById(Long.valueOf(id));
            if (i != 1) {
                return 0;
            }
        }
        return i;
    }

    /**
     * 修改上下线状态
     *
     * @param id
     * @return
     */
    @Override
    public int status(Long id, Integer status) {
        if (status == 1) {
            status = 0;
        } else if (status == 0) {
            status = 1;
        }
        return advertiseMapper.status(id, status);
    }

}
