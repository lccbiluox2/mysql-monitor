package com.neo.controller;

import com.neo.common.DubboResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/import")
@Slf4j
public class ImportController {


    /**
     * 上传文件
     *
     * @param request 上传文件请求
     * @return 操作结果
     */

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    public DubboResult<Boolean> uploadFile(HttpServletRequest request) {
        try {
            System.out.println("xxx");
//            fileService.uploadFile((MultipartHttpServletRequest) request);
            log.info("上传文件成功");
            return DubboResult.buildSuccessResult();
        } catch (Exception e) {
            return DubboResult.buildErrorResult("上传失败：{}", e.getMessage());
        }
    }

}
