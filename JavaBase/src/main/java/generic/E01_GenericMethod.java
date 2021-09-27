package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：泛型方法
 * 开发人员：@author MaLi
 */
public class E01_GenericMethod {
    public <T> List<T> getObject() {
        List<T> ts = new ArrayList<>();
        T t = (T) new Object();

        ts.add(t);
        return ts;
    }

    public <T> T doAction(T t) {
        try {
            return (T) t.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void M01_TestGetObject() {

        List<Person> list = getObject();
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());

    }

    @Test
    public void M02_Test_doAction() {
        Person person = new Person();
        Person newPerson = doAction(person);
        System.out.println(person);
        System.out.println(newPerson);
    }

    static class Person {
    }
}
