package com.nengli51.mvcfileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@Controller
@RequestMapping(value = "/demo")
public class FileUploadHandler {

    @RequestMapping(value = "/upload")
    public String doAction(@RequestParam(value = "uploadFile") MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        //1, 文件名
        String originalFilename = uploadFile.getOriginalFilename();
        //1.1 获取文件扩展名
        String extendedName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //1.2 使用uuid+文件扩展名创建新的名字
        String newName = UUID.randomUUID() + extendedName;

        //2, 文件保存路径: 按照日期保存文件
        // 创建日期文件夹
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(new Date());
        String realPath = request.getServletContext().getRealPath("/files");
        File dateFile = new File(realPath + "/" + dateString);
        if (!dateFile.exists()) {
            dateFile.mkdirs();
        }
        // 保存文件
        uploadFile.transferTo(new File(dateFile, newName));
        return "success";
    }
}
