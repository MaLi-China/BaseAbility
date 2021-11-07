package com.nengli51.fileupload; /**
 * 功能说明：
 * 开发人员：@author MaLi
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //文件下载方式1
        /*ServletInputStream inputStream = request.getInputStream();
        int length = 0;
        int _1M = 1024 * 1024;
        byte[] buffer = new byte[_1M];
        while ((length = inputStream.read(buffer)) != -1) {
            String s = new String(buffer,0,length);
            System.out.println(s);
        }*/

        //文件下载方式2
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            //中文内容处理
            request.setCharacterEncoding("utf-8");
            upload.setHeaderEncoding("utf-8");
            for (FileItem item : items) {
                if (item.isFormField()) {
                    System.out.println(item.getFieldName() + "---> " + item.getString());
                    String utf_8value = item.getString("utf-8");
                    System.out.println("修正乱码-->" + item.getFieldName() + "---> " + utf_8value);
                } else {
                    //文件名
                    String fileName = item.getName();
                    UUID uuid = UUID.randomUUID();
                    File file = new File(fileName + uuid);
                    try {
                        item.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
