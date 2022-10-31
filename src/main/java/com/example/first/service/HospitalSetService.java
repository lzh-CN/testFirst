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

    /**
     * mapper文件手写
     * @return
     */
    List<HospitalSet> seleAll();

    /**
     * mybatis-plus 调用
     * @return
     */
    List<HospitalSet> seleAllPlus();


    /**
     * mybatis-plus 增
     * @return
     */
    boolean insert();


    /**
     * mybatis-plus 该
     * @return
     */
    boolean updates();

    /**
     * mybatis-plus 删除
     * @return
     */
    boolean delete();
}
