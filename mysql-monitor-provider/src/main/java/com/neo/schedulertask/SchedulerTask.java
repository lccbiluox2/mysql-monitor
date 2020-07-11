package com.neo.schedulertask;

import com.neo.config.BlogConfig;
import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.Content;
import com.neo.service.ArticleService;
import com.neo.service.CategoryService;
import com.neo.utils.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SchedulerTask {

    @Autowired
    private BlogConfig blogConfig;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;


    /**
     * cron表达式中各时间元素使用空格进行分割，分别表示如下含义：
     * 按顺序依次为
     * 秒（0~59）
     * 分钟（0~59）
     * 小时（0~23）
     * 天（月）（0~31，但是你需要考虑你月的天数）
     * 月（0~11）
     * 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 7.年份（1970－2099）
     */

//    @Scheduled(cron = "6 * * * * ?")
//    private void process() {
//        System.out.println("this is scheduler task runing  ");
//        String address = blogConfig.getBlogAddress();
//        FileUtils.getFiles(address);
//        List<File> files = FileUtils.getFiles();
////        initArticle(files);
//    }
//
    public void initArticle(List<File> files) {
        List<Category> categories = categoryService.getList();
        String baseAddress = blogConfig.getBlogAddress();
        for (File file : files) {
            String fileName = file.getName();
            String filePath = file.getPath();
            System.out.println(fileName);
            System.out.println(filePath);
            String[] fileRelative = filePath.replace(baseAddress, "").split("\\/");
            String fileAddress = "docs/" + fileRelative[1];
            Integer categoryId = null;
            for (Category category : categories) {
                if (category.getAddress().equals(fileAddress)) {
                    categoryId = category.getId();
                }
            }
            // 是博客
            if (fileName.endsWith("md") && fileAddress.contains("siddhi")) {
                String newFileName = fileName.replace(".md", "");
                Article article = articleService.getArticleByName(newFileName);
                if (article == null) {
                    String contentText = FileUtils.readFileByLines(filePath);

                    article = new Article();
                    article.setTitle(newFileName);
                    article.setCtime(new Date());
                    article.setMtime(new Date());
                    if(contentText != null && contentText.length() > 255){
                        article.setDigest(contentText.substring(0,254));
                    }
                    article.setArticleType("远程");
                    article.setModality("公开");
                    article.setCtime(new Date());
                    article.setMtime(new Date());
                    article.setContent(contentText);
                    article.setAddress(filePath);
                    article.setCategoryId(categoryId);
                    articleService.insert(article);
                }
            }
        }
    }

}
