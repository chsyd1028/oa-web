package com.zmh.oaweb.mapper;

import com.zmh.oaweb.model.Adminext;
import com.zmh.oaweb.model.AdminextExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminextMapper {
    long countByExample(AdminextExample example);

    int deleteByExample(AdminextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adminext record);

    int insertSelective(Adminext record);

    List<Adminext> selectByExampleWithBLOBs(AdminextExample example);

    List<Adminext> selectByExample(AdminextExample example);

    Adminext selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adminext record, @Param("example") AdminextExample example);

    int updateByExampleWithBLOBs(@Param("record") Adminext record, @Param("example") AdminextExample example);

    int updateByExample(@Param("record") Adminext record, @Param("example") AdminextExample example);

    int updateByPrimaryKeySelective(Adminext record);

    int updateByPrimaryKeyWithBLOBs(Adminext record);

    int updateByPrimaryKey(Adminext record);


}