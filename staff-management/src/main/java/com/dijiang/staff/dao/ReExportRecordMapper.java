package com.dijiang.staff.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dijiang.common.entity.ReExportRecord;
import com.dijiang.common.entity.ReExportStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ReExportRecordMapper extends BaseMapper<ReExportRecord> {




//
//    @Select("<script>" +
//            " select  t1.parent_export_id AS id,task.file_id,task.file_name,t1.total,t1.initCount,t1.normalCount,t1.excepCount from ( " +
//            " select * from( " +
//            " select  parent_export_id,count(id) AS total " +
//            " from  (select * from tb_export_task  ${ew.customSqlSegment} )innerTotal  " +
//            " where reexport_mark = \"true\" group by parent_export_id " +
//            " ) total   " +
//            " " +
//            " LEFT JOIN (select  parent_export_id AS intiId,count(id) AS initCount " +
//            " from (select * from tb_export_task ${ew.customSqlSegment} )innserInit " +
//            " where reexport_mark = \"true\" and export_status = 1  group by parent_export_id) init " +
//            " ON total.parent_export_id =  init.intiId " +
//            " " +
//            " LEFT JOIN (select  parent_export_id AS normalId,count(id) AS normalCount " +
//            " from (select * from tb_export_task ${ew.customSqlSegment} )innerNormal " +
//            " where reexport_mark =  \"true\" and export_status = 2  group by parent_export_id) normal " +
//            " ON total.parent_export_id =  normal.normalId " +
//            " " +
//            " LEFT JOIN (select  parent_export_id AS excepId,count(id) AS excepCount  " +
//            " from (select * from tb_export_task ${ew.customSqlSegment} )innerExcep " +
//            " where reexport_mark = \"true\" and export_status = 3  group by parent_export_id) excep " +
//            " ON total.parent_export_id =  excep.excepId " +
//            " " +
//            " )t1 " +
//            "  LEFT JOIN tb_export_task task " +
//            " ON t1.parent_export_id =  task.id " +
//            "</script> ")
//    public List<ReExportCount> selectPagesafdasfa(IPage<ReExportRecord> page , @Param(Constants.WRAPPER) LambdaQueryWrapper<ReExportRecord> lambdaQuery);



    @Select("<script>" +
            " select  t1.parent_export_id AS id,t1.total,t1.initCount,t1.normalCount,t1.exceptionCount , task.file_id,task.file_name,task.application_id,task.application_name,task.modular_id,task.modular_name ,task.site_code,task.site_name,task.create_user_id,task.user_name,task.create_time from ( " +
            " select * from( " +
            " select  parent_export_id,count(id) AS total " +
            " from  (select * from tb_export_task  ${ew.customSqlSegment} )innerTotal  " +
            " where reexport_mark = \"true\" group by parent_export_id " +
            " ) total   " +
            " " +
            " LEFT JOIN (select  parent_export_id AS intiId,count(id) AS initCount " +
            " from (select * from tb_export_task ${ew.customSqlSegment} )innerInit " +
            " where reexport_mark = \"true\" and export_status = 1  group by parent_export_id) init " +
            " ON total.parent_export_id =  init.intiId " +
            " " +
            " LEFT JOIN (select  parent_export_id AS normalId,count(id) AS normalCount " +
            " from (select * from tb_export_task ${ew.customSqlSegment} )innerNormal " +
            " where reexport_mark =  \"true\" and export_status = 2  group by parent_export_id) normal " +
            " ON total.parent_export_id =  normal.normalId " +
            " " +
            " LEFT JOIN (select  parent_export_id AS exceptionId,count(id) AS exceptionCount  " +
            " from (select * from tb_export_task ${ew.customSqlSegment} )innerException " +
            " where reexport_mark = \"true\" and export_status = 3  group by parent_export_id) exception " +
            " ON total.parent_export_id =  exception.exceptionId " +
            " " +
            " )t1 " +
            "  LEFT JOIN tb_export_task task " +
            " ON t1.parent_export_id =  task.id " +
            "</script> ")
    public List<ReExportStatistics> selectPagesafdasfa(IPage<ReExportRecord> page , @Param(Constants.WRAPPER) LambdaQueryWrapper<ReExportRecord> lambdaQuery);


    public List<ReExportRecord> getoneone();
}
