package OOP.singleton

import java.text.SimpleDateFormat
import java.util.Date

/**
 * 功能说明：测试单例对象object
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/29
 */
object DateUtils {
  val pattern = new SimpleDateFormat("yyyy-MM-dd")

  def format(date: Date): String = {
    pattern.format(date)
  }

  def parse(dateString: String): Date = {
    pattern.parse(dateString)
  }

  /**
   * main方法作为程序的入口, 只能在object中出现, 因为只有object中才可以出现静态的方法
   *
   * @param args 参数列表
   */
  def main(args: Array[String]): Unit = {
    var now = new Date()
    println(DateUtils.format(now))
    println(DateUtils.parse("2021-4-29"))
  }
}
