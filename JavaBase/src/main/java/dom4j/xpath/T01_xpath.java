package dom4j.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_xpath {
    Element rootElement;

    @Before
    public void getSaxReader() {
        SAXReader reader = new SAXReader();
        InputStream inputStream = T01_xpath.class.getClassLoader().getResourceAsStream("books.xml");

        Document document = null;
        try {
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        rootElement = document.getRootElement();
    }

    @Test
    public void testXpath1() {
        //获取当前标签的子标签
        List<Element> bookstore = rootElement.selectNodes("//title|//price");
       /* List<> root = rootElement.selectNodes("/");
        List<Element> titles = rootElement.selectNodes("//title");
        for (Element title : titles) {
            Node parent = title.selectSingleNode("..");
            System.out.println(parent.getText());
        }*/
        for (Element element : bookstore) {
            System.out.println(element);
        }

    }
}
