package dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

/**
 * 功能说明：测试使用Dom4J解析XML
 * 开发人员：@Author MaLi
 */
public class TestAPI01 {

    @Test
    public void testMethod4() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("bookstore.xml");
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        //选取所有 title
        Element element = rootElement.element("book").element("title");
        System.out.println(element.getText());
        // 选取第一个 book 的 title
        Node node = rootElement.selectSingleNode("//title");
        System.out.println(node.getText());

    }

    @Test
    public void testMethod3() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("som.xml");
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Node> parent = rootElement.selectNodes("parent");
        List<Node> nodes = document.selectNodes("root");
        Iterator<Node> iterator = parent.iterator();
        for (; iterator.hasNext(); ) {
            Node node = iterator.next();
            System.out.println(node.getText());
        }
    }

    @Test
    //测试遍历
    public void testMethod2() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("som.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        Element parent = root.element("parent");
        Iterator<Element> iterator = parent.elementIterator();
        for (; iterator.hasNext(); ) {
            Element element = iterator.next();
            System.out.println(element.getTextTrim());
            Attribute name = element.attribute("name");
            System.out.println(name.getValue());
        }
    }

    @Test
    public void method1_load() throws DocumentException, IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        InputStream inputStream = TestAPI01.class.getClassLoader().getResourceAsStream("som.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        //新增节点
        Element sonNode = rootElement.addElement("son");
        Element sonsonNode = sonNode.addElement("sonson");
        sonsonNode.setText("sonsonNodeText");
        Element sonson2 = sonNode.addElement("sonson2");
        sonson2.setText("sonson2NodeText");
        //写入XML文件
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("som.xml"), "UTF-8"));
        writer.write(document);
        writer.close();

    }
}























