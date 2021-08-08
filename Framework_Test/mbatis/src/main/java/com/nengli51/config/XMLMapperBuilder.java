package com.nengli51.config;

import com.nengli51.pojo.Configuration;
import com.nengli51.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 功能说明：工场, 用于解析xxxMapper.xml
 * 开发人员：@Author MaLi
 */
public class XMLMapperBuilder {
    public void parseMapper(InputStream inputStream, Configuration configuration) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        //1, sqlID
        String namespace = rootElement.attribute("namespace").getValue();
        List<Element> selectElement = rootElement.selectNodes("/mapper/*");
        for (Element element : selectElement) {
            String sql = element.getTextTrim();
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String parameterType = element.attributeValue("parameterType");
            MappedStatement mappedStatement = new MappedStatement();
            String sqlId = namespace + "." + id;
            mappedStatement.setSqlId(sqlId);
            mappedStatement.setSql(sql);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(parameterType);
            configuration.getMappedStatements().put(sqlId, mappedStatement);
        }
    }

    @Test
    public void testParseMapper() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("userMapper.xml");
        Configuration configuration = new Configuration();
        try {
            this.parseMapper(inputStream, configuration);
            Map<String, MappedStatement> statements = configuration.getMappedStatements();
            Collection<MappedStatement> values = statements.values();
            for (MappedStatement value : values) {
                System.out.println(value);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public void testDom4J() {
        //获取子Element测试

    }
}
