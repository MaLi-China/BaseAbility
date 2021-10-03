package com.nengli51.config;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Configuration {
    private DataSource dataSource;
    private Map<String, MapperStatement> mapperStatementMap;

    public Map<String, MapperStatement> getMapperStatementMap() {
        return mapperStatementMap;
    }

    public void setMapperStatementMap(Map<String, MapperStatement> mapperStatementMap) {
        this.mapperStatementMap = mapperStatementMap;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

