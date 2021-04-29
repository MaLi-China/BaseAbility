package OOP.constructor

import org.junit.Test

/**
 * 功能说明：主构造器的第二种写法
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/29
 */
class Student(var name: String, val age: Int) {

  def this() {
    this("name is Null", 18)
  }

  def showInfo(): Unit = {
    println(s"Name: $name,Age:$age")
  }

  /**
   * java.lang.IllegalArgumentException: Test class can only have one constructor
   * 该测试用例不能执行, 只能去另一个类中测试
   */
  @Test
  def testConstructor(): Unit = {
    val student = new Student()
    student.showInfo()
  }


}

class TestStudent {
  @Test
  def testShowInfo(): Unit = {
    val mark = new Student("Mark", 18)
    mark.showInfo()
  }
}