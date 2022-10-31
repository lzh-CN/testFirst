package com.example.first.mapper;

import com.example.first.domain.HospitalSet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
* @author admin
* @description 针对表【hospital_set(医院设置表)】的数据库操作Mapper
* @createDate 2022-10-31 09:52:23
* @Entity generator.domain.HospitalSet
*/
public interface HospitalSetMapper extends BaseMapper<HospitalSet> {

    List<HospitalSet> selectAll();
}




