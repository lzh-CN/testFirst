package com.example.first.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.first.domain.HospitalSet;
import com.example.first.service.HospitalSetService;
import com.example.first.mapper.HospitalSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author admin
* @description 针对表【hospital_set(医院设置表)】的数据库操作Service实现
* @createDate 2022-10-31 09:52:23
*/
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet>
    implements HospitalSetService{


    @Resource
    HospitalSetMapper hospitalSetMapper;

    @Override
    public List<HospitalSet> seleAll() {
        return hospitalSetMapper.selectAll();
    }
}




