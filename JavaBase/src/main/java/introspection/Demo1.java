package introspection;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Demo1 {
    //测试内省方法
    @Test
    public void testMethod1() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        User user = new User();
        user.setUsername("xxx");
        for (PropertyDescriptor descriptor : propertyDescriptors) {

            Method readMethod = descriptor.getReadMethod();
            if (readMethod.getName().equals("getUsername")) {
                String username = (String) readMethod.invoke(user);
                System.out.println(username);
            }

        }
    }
}
