package com.example.first.service;

import com.example.first.domain.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author admin
* @description 针对表【hospital_set(医院设置表)】的数据库操作Service
* @createDate 2022-10-31 09:52:23
*/
public interface HospitalSetService extends IService<HospitalSet> {

    List<HospitalSet> seleAll();
}
