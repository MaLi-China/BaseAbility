package OOP.constructor

/**
 * 功能说明：构造器 - 主构造器的使用
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/29
 */
class Person(namex: String, agex: Int) {
  var name: String = namex
  var age: Int = agex
  println("Main constructor is running...")


}

object Main {
  def main(args: Array[String]): Unit = {
    val person = new Person("Mark", 18)

  }
}
