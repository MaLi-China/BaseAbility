package com.nengli51.config;

/**
 * 功能说明：Represent a SqlStatement in XXXMapper.xml
 * 开发人员：@author MaLi
 */
public class MapperStatement {
    private String mapperStatementId;
    private String parameterType;
    private String resultType;
    private String sql;

    public MapperStatement(String mapperStatementId, String parameterType, String resultType, String sql) {
        this.mapperStatementId = mapperStatementId;
        this.parameterType = parameterType;
        this.resultType = resultType;
        this.sql = sql;
    }

    public String getMapperStatementId() {
        return mapperStatementId;
    }

    public void setMapperStatementId(String mapperStatementId) {
        this.mapperStatementId = mapperStatementId;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "MapperStatement{" +
                "mapperStatementId='" + mapperStatementId + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
