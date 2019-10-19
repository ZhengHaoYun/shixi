package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Resume;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.ResumeService;
import com.zhy.shixi.service.UserService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/12
 */
@RestController
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @Autowired
    UserService userService;

    @PostMapping("/resumes/{userId}")
    public Result upload(@PathVariable("userId") int userId, MultipartFile file) {
        User user = userService.get(userId);
        Resume resume = new Resume();

        String fileName = file.getOriginalFilename();
        resume.setResumeName(fileName);
        resume.setUser(user);

        String folder = "src/main/resources/static/resume";
        File destFolder = new File(folder);
        File dest = new File(destFolder.getAbsolutePath() + File.separator + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        if(dest.exists()){
            return Result.fail("该简历已存在，请重新上传！");
        }
        try {
            file.transferTo(dest);
            resumeService.add(resume);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail("上传文件失败！");
        }

        return Result.success(resume);

    }

    @GetMapping("/resumes/{userId}")
    public Result list(@PathVariable("userId") int userId) {
        User user = userService.get(userId);
        List<Resume> resumes = resumeService.getByUserId(userId);
        return Result.success(resumes);
    }

    @DeleteMapping("/resumes/{resumeId}")
    public Result delete(@PathVariable("resumeId") int resumeId) {
        Resume resume = resumeService.get(resumeId);
        String fileName = resume.getResumeName();
        String folder = "src/main/resources/static/resume";
        File destFolder = new File(folder);
        File dest = new File(destFolder.getAbsolutePath() + File.separator + fileName);
        resumeService.delete(resumeId);
        dest.delete();
        return Result.success();
    }

    @GetMapping("/resume/{resumeId}")
    public Result get(@PathVariable("resumeId") int resumeId) {
        Resume resume = resumeService.get(resumeId);
        return Result.success(resume);
    }
}
