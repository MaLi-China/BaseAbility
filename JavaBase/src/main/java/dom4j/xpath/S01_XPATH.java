package dom4j.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class S01_XPATH {
    @Test
    public void mt01() {
        SAXReader saxReader = new SAXReader();
        InputStream is = S01_XPATH.class.getResourceAsStream("/bookstore.xml");
        try {
            Document document = saxReader.read(is);
            Element rootElement = document.getRootElement();
            //1, 打印根标签
            System.out.println(rootElement.getName());
            //1, 获取节点的子节点
            List<Element> list = rootElement.selectNodes("//title[@lang='ch']");
            for (Element o : list) {
                System.out.println(o.getName() + " -- " + o.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
