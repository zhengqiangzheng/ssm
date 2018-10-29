package com.zq.controller;

import com.zq.po.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author zq
 * @create 2018-10-25 19:30
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("/test")
    public String testUser() {
        return "user";
    }

    @RequestMapping("uu")
    public ModelAndView testUser1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        User user = new User();
        user.setName("zq");
        user.setId(11);
        modelAndView.addObject("user", user);
        return modelAndView;

    }
    @RequestMapping("/t1")
    public String t2(ModelMap modelMap, HttpServletRequest request) {
        User user = new User();
        user.setName("lall");
        modelMap.addAttribute("user", user);

        return "user";
    }

    @RequestMapping("demo/{id}/{name}")
    public String demo(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);

        return "demo";
    }

    @RequestMapping("demo/{id}/{name}/{age}")
    public String demo2(@PathVariable("id") Integer sid, @PathVariable("name") String sname,@PathVariable("age") Integer sage) {

        System.out.println(sid);
        System.out.println(sname);
        System.out.println(sage);

        return "demo";
    }
    @RequestMapping("hh")
    @ResponseBody
    public User user() {
        User user = new User();
        user.setName("zz");
        user.setId(111);
        return user;
    }

    @RequestMapping("upload")
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        File name = new File("/"+originalFilename);//要放在本地的哪里,这里使用/代表项目的根目录
        file.transferTo(name);//吧选中的文件传到上一行的路径其
                                        //如果是多个文件,使用MultipartFile[] 然后foreeach

        return "demo";

    }

    @RequestMapping("/down")
    public ResponseEntity<byte[]> download() throws IOException {
        String path = "d:/1.png";
        //中文路径有乱码
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();//更改传输头
        headers.setContentDispositionFormData("attachment", path);
        //上面是根据路径找到附件 ，告诉浏览器有个附件
        headers.setContentType(MediaType.IMAGE_PNG);//告诉返回类型
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    @RequestMapping("dd")
    public String demo() {
        return "demo";
    }



}
