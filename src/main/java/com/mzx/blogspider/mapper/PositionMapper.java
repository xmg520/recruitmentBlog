package com.mzx.blogspider.mapper;

import com.mzx.blogspider.pojo.PositionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public abstract interface PositionMapper
{
    @Select({"select * from recruitment limit #{page},#{dataNum}"})
    public abstract List<PositionInfo> getData(int paramInt1, int paramInt2);

    @Select({"select * from recruitment WHERE city_code ='${cityCode}' limit #{page},#{dataNum}"})
    public abstract List<PositionInfo> getDataByCity(int page, int dataNum, String cityCode);

    @Select({"select count(*) from recruitment"})
    public abstract int getDataCount();

    @Select({"select * from recruitment where id = #{id}"})
    @Results({@org.apache.ibatis.annotations.Result(property="responsibility", column="responsibility", javaType=String.class, typeHandler=org.apache.ibatis.type.StringTypeHandler.class)})
    public abstract PositionInfo getPositionById(String paramString);
}