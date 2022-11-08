//package yi.springboot.controller;
//
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.core.util.StrUtil;
//import cn.hutool.crypto.SecureUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import yi.springboot.mapper.FileMapper;
//import yi.springboot.pojo.Files;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.util.List;
//
///**
// * @aythor yi
// * @data 2022/10/29  00:34:09
// * @Description 文件上传
// */
//@Deprecated
//@RestController
//@RequestMapping("/file")
//public class FileController {
//    @Resource
//    private FileMapper fileMapper;
//
//    @Value("${files.upload.path}")
//    private String fileUploadPath;
//
//    @PostMapping("/upload")
//    public String upload(@RequestParam MultipartFile file) throws IOException {
//        String OriginalFilename = file.getOriginalFilename();
//        String type = FileUtil.extName(OriginalFilename);
//        long size = file.getSize();
//
//
//        String uuid = IdUtil.fastSimpleUUID();
//        String fileUUid = uuid + StrUtil.DOT + type;
//        File uploadFile = new File(fileUploadPath + fileUUid);
////        判断文件是否存在
//        File parentFile = uploadFile.getParentFile();
//        if (!parentFile.exists()){
//            parentFile.mkdirs();
//        }
////        当文件存在在获取
//        if (uploadFile.exists()){
////        获取文件md5
//            String md5 = SecureUtil.md5(uploadFile);
//            Files dbfiles = getFileByMd5(md5);
//            String url;
//            if (dbfiles != null){
//                url = dbfiles.getUrl();
//            } else {
//                //获取的文件存到磁盘
//                file.transferTo(uploadFile);
//                url = "http://localhost:9090/" + fileUUid;
//            }
//        } else {
//            //获取的文件存到磁盘
//            file.transferTo(uploadFile);
//        }
//
//
//
//
////        存储数据库
//        Files saveFile = new Files();
//        saveFile.setName(OriginalFilename);
//        saveFile.setType(type);
//        saveFile.setSize(size/1024); // 单位 kb
//        saveFile.setUrl(url);
//        saveFile.setMd5(md5);
//        fileMapper.insert(saveFile);
//        return url;
//    }
//
//    @GetMapping("/{fileUUid}")
//    public void download(@PathVariable String fileUUid, HttpServletResponse response) throws IOException{
////        根据文件的唯一标识码获取文件
//        File uploadFile = new File(fileUploadPath + fileUUid);
////        设置输出流格式
//        ServletOutputStream os = response.getOutputStream();
//        response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileUUid,"UTF-8"));
//        response.setContentType("application/octet-stream");
////        获取文件的字节流
//        os.write(FileUtil.readBytes(uploadFile));
//        os.flush();
//        os.close();
//    }
//
//    /**
//     * 通过文件的md5查询文件
//     * @param md5
//     * @return
//     */
//    private Files getFileByMd5(String md5) {
//        // 查询文件的md5是否存在
//        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("md5", md5);
//        List<Files> filesList = fileMapper.selectList(queryWrapper);
//        return filesList.size() == 0 ? null : filesList.get(0);
//    }
//
//
//}
