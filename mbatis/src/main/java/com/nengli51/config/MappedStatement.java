package com.nengli51.config;

/**
 * 功能说明：Representing Mapper Configuration Files
 * 开发人员：@author MaLi
 */
public class MappedStatement {
    private String mapperId; // namespace+id
    private String resultType;
    private String parameterType;
    private String sql;

    public String getMapperId() {
        return mapperId;
    }

    public void setMapperId(String mapperId) {
        this.mapperId = mapperId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
