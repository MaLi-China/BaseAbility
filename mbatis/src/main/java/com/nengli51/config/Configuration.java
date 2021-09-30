package com.nengli51.config;

import javax.sql.DataSource;
import java.util.List;

/**
 * 功能说明：Representing main configuration files,  such as sqlMapConfig.xml.
 * 开发人员：@author MaLi
 */
public class Configuration {
    private DataSource dataSource;
    private List<MappedStatement> mappedStatements;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(List<MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }
}
