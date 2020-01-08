package com.aaa.repast.admin.project.system.advertisePosition.service;

import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.aaa.repast.admin.project.system.advertisePosition.mapper.AdvertisePositionMapper;
import com.aaa.repast.admin.project.system.advertisePosition.domain.AdvertisePosition;

/**
 * 广告位位置 服务层实现
 *
 * @author Seven Lee
 * @date 2020-01-03
 */
@Service
public class AdvertisePositionServiceImpl implements IAdvertisePositionService {
    @Autowired
    private AdvertisePositionMapper advertisePositionMapper;

    /**
     * 查询广告位位置信息
     *
     * @param id 广告位位置ID
     * @return 广告位位置信息
     */
    @Override
    public AdvertisePosition selectAdvertisePositionById(Long id) {
        return advertisePositionMapper.selectAdvertisePositionById(id);
    }

    /**
     * 查询广告位位置列表
     *
     * @param advertisePosition 广告位位置信息
     * @return 广告位位置集合
     */
    @Override
    public List<AdvertisePosition> selectAdvertisePositionList(AdvertisePosition advertisePosition) {
        return advertisePositionMapper.selectAdvertisePositionList(advertisePosition);
    }

    /**
     * 新增广告位位置
     *
     * @param advertisePosition 广告位位置信息
     * @return 结果
     */
    @Override
    public int insertAdvertisePosition(AdvertisePosition advertisePosition) {
        advertisePosition.setDelStatus(1);
        return advertisePositionMapper.insertAdvertisePosition(advertisePosition);
    }

    /**
     * 修改广告位位置
     *
     * @param advertisePosition 广告位位置信息
     * @return 结果
     */
    @Override
    public int updateAdvertisePosition(AdvertisePosition advertisePosition) {
        return advertisePositionMapper.updateAdvertisePosition(advertisePosition);
    }

    /**
     * 删除广告位位置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */

    @Override
    public int deleteAdvertisePositionByIds(String ids) {
        int i = 0;
        for (String id : Convert.toStrArray(ids)) {
            i = advertisePositionMapper.deleteAdvertisePositionById(Long.valueOf(id));
            if (i != 1) {
                return 0;
            }
        }
        return i;
    }

    /**
     * 查询广告位置名称
     *
     * @return
     */
    @Override
    public List<AdvertisePosition> selectAdvertisePositionName() {
        List<AdvertisePosition> advertisePositions = advertisePositionMapper.selectAdvertisePositionName();
        return advertisePositions;
    }

}
