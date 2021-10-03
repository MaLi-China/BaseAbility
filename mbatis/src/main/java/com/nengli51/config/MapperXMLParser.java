package com.nengli51.config;

import com.nengli51.io.Resources;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 功能说明：Used to parse Mapper Configuration Files
 * 开发人员：@author MaLi
 */
public class MapperXMLParser {
    /**
     * parse the Mapper Configuration into configuration files
     *
     * @param mapperFile    Mapper Configuration Files
     * @param configuration Bean represent Configuration
     */
    public static void parse(String mapperFile, Configuration configuration) throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream inputStream = Resources.getResourceAsStream("UserMapper.xml");
        try {
            //解析Mapper.xml文件
            Document document = reader.read(inputStream);
            Element rootElement = document.getRootElement();
            String namespace = rootElement.attribute("namespace").getValue();

            List<Element> mappers = rootElement.selectNodes("/mapper/*");
            HashMap<String, MapperStatement> mapperStatementHashMap = new HashMap<>();
            MapperStatement statement;
            for (Element element : mappers) {
                String statementId = namespace + "." + element.attribute("id").getValue(); // statementId
                String parameterType = element.attribute("parameterType").getValue();
                String resultType = element.attribute("resultType").getValue();
                String sql = element.getTextTrim();
                //每一个SqlStatement保存到Statement对象中: statementId, parameterType, resultType, Sql
                statement = new MapperStatement(statementId, parameterType, resultType, sql);
                // Map: statementId <--> statement
                mapperStatementHashMap.put(statementId, statement);
            }
            // 保存所有的statement到configuration中
            configuration.setMapperStatementMap(mapperStatementHashMap);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
