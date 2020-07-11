package com.neo.controller;

import com.neo.common.DubboResult;
import com.neo.entity.Article;
import com.neo.entity.Category;
import com.neo.entity.req.ArticleAddReq;
import com.neo.entity.req.SearchText;
import com.neo.entity.response.ArticleDetail;
import com.neo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据类别获取文章
     *
     * @param articleAddReq
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult add(@RequestBody ArticleAddReq articleAddReq) {

        Article article = new Article();

        String title = articleAddReq.getTitle();
        String content = articleAddReq.getContent();
        String digest = "";
        if (content != null) {
            digest = content.substring(0, 254);
        }
        String categoryIds = articleAddReq.getCategoryIds();
        String[] cateIds = categoryIds.split(",");
        if (1 <= cateIds.length) {
            article.setCategoryId(Integer.parseInt(cateIds[0]));
        }
        if (2 <= cateIds.length) {
            article.setCategoryId1(Integer.parseInt(cateIds[1]));
        }
        if (3 <= cateIds.length) {
            article.setCategoryId2(Integer.parseInt(cateIds[2]));
        }

        String articleType = articleAddReq.getArticleType();
        String modality = articleAddReq.getModality();

        article.setTitle(title);
        article.setDigest(digest);
        article.setArticleType(articleType);
        article.setModality(modality);
        article.setCtime(new Date());
        article.setMtime(new Date());
        article.setContent(content);
        article.setAddress(articleAddReq.getAddress());
        article.setKeys(articleAddReq.getKeys());
        article.setSaveMethod(articleAddReq.getSaveMethod());

        Article articleInDb = articleService.getArticleByName(title);
        if (articleInDb == null) {
            articleService.insert(article);
        }else {
            return DubboResult.buildErrorResult("文件已经存在");
        }

        return DubboResult.buildSuccessResult();
    }


    /**
     * 根据类别获取文章
     *
     * @param articleAddReq
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult edit(@RequestBody ArticleAddReq articleAddReq) {
        Integer id = articleAddReq.getId();
        Article articleInDb = articleService.getArticleById(id);
        if (articleInDb == null) {
            throw new RuntimeException("文章不存在");
        }

        Article article = new Article();

        String title = articleAddReq.getTitle();
        String address = articleAddReq.getAddress();
        String contentText = articleAddReq.getContent();
        String digest = "";
        if (contentText != null) {
            digest = contentText.substring(0, 254);
        }
        String categoryIds = articleAddReq.getCategoryIds();
        String[] cateIds = categoryIds.split(",");
        if (1 <= cateIds.length) {
            article.setCategoryId(Integer.parseInt(cateIds[0]));
        }
        if (2 <= cateIds.length) {
            article.setCategoryId1(Integer.parseInt(cateIds[1]));
        }
        if (3 <= cateIds.length) {
            article.setCategoryId2(Integer.parseInt(cateIds[2]));
        }

        String articleType = articleAddReq.getArticleType();
        String modality = articleAddReq.getModality();

        article.setId(id);
        article.setTitle(title);
        article.setDigest(digest);
        article.setArticleType(articleType);
        article.setModality(modality);
        article.setCtime(new Date());
        article.setMtime(new Date());
        article.setAddress(address);

        articleService.updateArticle(article);

        return DubboResult.buildSuccessResult();
    }


    /**
     * 根据类别获取文章
     *
     * @param searchText
     * @return
     */
    @RequestMapping(value = "/getArticleByCate", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult<List<Category>> getArticleByCate(@RequestBody SearchText searchText) {
        Integer categoryId = searchText.getCategoryId();
        List<Category> categorys = articleService.getArticleByCateId(categoryId);
        return DubboResult.buildSuccessResult(categorys);
    }


    /**
     * 获取文章详情
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public DubboResult<ArticleDetail> getContentByArticleId(@RequestBody Article article) {
        Integer id = article.getId();
        Article articleIdb = articleService.getArticleById(id);

        // 设置图片的父地址
        String address = articleIdb.getAddress();
        int index = address.lastIndexOf("/");
        String imagePath = address.substring(0, index + 1);
        ArticleDetail articleDetail = new ArticleDetail();
        BeanUtils.copyProperties(articleIdb, articleDetail);
        articleDetail.setImagePath(imagePath);

        return DubboResult.buildSuccessResult(articleDetail);
    }

}
