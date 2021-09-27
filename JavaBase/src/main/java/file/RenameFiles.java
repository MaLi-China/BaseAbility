package file;

import java.io.File;

/**
 * 功能说明: 修改文件夹内所有文件的名称为原名称去掉广告
 * 开发人员：@Author MaLi
 */
public class RenameFiles {
    public static void renameFiles(String folderPath) {
        File[] files = new File(folderPath).listFiles();
        for (File file : files) {
            String parentPath = file.getParentFile().getPath();
            String docName = file.getName();
            int index = docName.indexOf("-");
            String substring = "\\" + docName.substring(0, index) + ".mp4";
            String newName = parentPath + substring;
            file.renameTo(new File(newName));
        }
    }

    public static void main(String[] args) {
    }
}
