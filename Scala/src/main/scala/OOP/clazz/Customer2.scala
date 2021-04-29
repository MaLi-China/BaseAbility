package OOP.clazz

import java.util.Date
import scala.beans.BeanProperty

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/29
 */
@BeanProperty
class Customer2 {
  var name: String = _
  var gender: String = _
  var registerDate: Date = new Date()

  def sayHi(msg: String): Unit = {
    println(msg)
  }
}

object MainX {
  def main(args: Array[String]): Unit = {
    val customer = new Customer2
    customer.name = "Mark"
    customer.gender = "Male"
    customer.sayHi("Hello Object")
  }

}
