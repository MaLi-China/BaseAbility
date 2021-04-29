package OOP.clazz

import java.util.Date

/**
 * 功能说明：Scala的类
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/29
 */
class Customer {
  // 下面的 " _ " 表示使用默认值进行初始化
  var name: String = _
  var gender: String = _
  val registerDate: Date = new Date

  def sayHi(msg: String): Unit = {
    println(msg)
  }
}


object Mainx {
  // main方法必须要放在一个scala的`object`（单例对象）中才能执行
  def main(args: Array[String]): Unit = {
    val customer = new Customer
    customer.name = "Mark"
    customer.gender = "male"
    //字符串中的变量替换: ${变量}使用变量替换掉内容
    println(s"姓名: ${customer.name}, 性别: ${customer.gender}, 注册时间: ${customer.registerDate}")
    customer.sayHi("Hello Scala...")
  }
}
