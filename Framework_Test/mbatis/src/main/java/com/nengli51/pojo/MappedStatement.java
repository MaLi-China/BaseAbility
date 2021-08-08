package com.nengli51.pojo;

/**
 * 功能说明：存储xxxMapper.xml解析信息
 * 开发人员：@Author MaLi
 */
public class MappedStatement {
    private String sqlId;
    private String resultType;
    private String paramterType;
    private String sql;

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamterType() {
        return paramterType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "sqlId='" + sqlId + '\'' +
                ", resultType='" + resultType + '\'' +
                ", paramterType='" + paramterType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
