package DP09_Composite.FileSystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：模拟文件目录
 * 开发人员：@author MaLi
 */
public class FileSystemNode {
    private String path;
    private boolean isFile;
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //添加子节点
    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    //删除子节点
    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }

    //计算树新结构里面文件的个数
    public int countNumOfFiles() {
//        在根节点开始遍历
        if (this.isFile) {
            return 1;
        }
        int result = 0;
        for (FileSystemNode subNode : this.subNodes) {
            result += countNumOfFiles();
        }
        return result;
    }

    public long countSizeOfFiles() {
        File file = new File(this.getPath());
        if (!file.exists()) return 0;
        if (this.isFile) {
            return file.length();
        }
        int size = 0;
        for (FileSystemNode subNode : this.subNodes) {
            size += subNode.countSizeOfFiles();
        }
        return size;
    }
}