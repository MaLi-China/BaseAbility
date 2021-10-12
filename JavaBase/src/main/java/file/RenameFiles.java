package file;

import java.io.File;

/**
 * 功能说明: 修改文件夹内所有文件的名称为原名称去掉广告
 * 开发人员：@Author MaLi
 */
public class RenameFiles {
    /**
     * 去除文件夹下所有文件的名称广告
     *
     * @param folderPath 文件夹
     * @param postfix    文件后缀
     */
    public static void renameFiles(String folderPath, String postfix) {
        File[] files = new File(folderPath).listFiles();
        for (File file : files) {
            String parentPath = file.getParentFile().getPath();
            String docName = file.getName();
            int index = docName.indexOf("-");
            String substring = "\\" + docName.substring(0, index) + postfix;
            String newName = parentPath + substring;
            file.renameTo(new File(newName));
        }
    }

    public static void main(String[] args) {
        renameFiles("E:\\01.架构师课程\\03.拉勾高级架构师\\01 第一阶段 开源框架源码剖析\\模块2 IoC容器设计实现及Spring源码分析\\01.任务一：自定义IoC&AOP框架", ".mp4");
    }
}
