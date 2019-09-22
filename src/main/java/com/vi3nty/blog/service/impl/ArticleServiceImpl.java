package com.vi3nty.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vi3nty.blog.entity.Article;
import com.vi3nty.blog.entity.vo.ArticleVo;
import com.vi3nty.blog.mapper.ArticleMapper;
import com.vi3nty.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public int addArticle(Article article) {
        int result=articleMapper.insert(article);
        return result;
    }


    @Override
    public IPage<ArticleVo> list(int currentPage, int pageSize) {
        IPage<Article> page=new Page<>(currentPage,pageSize);
        return articleMapper.getArticlesPage(page);
    }
    @Override
    public IPage<ArticleVo> listByCid(int currentPage, int pageSize, int cid) {
        IPage<ArticleVo> page=new Page<>(currentPage,pageSize);
        page.setRecords(articleMapper.getArticlesPageByCid(cid,page));
        return page;
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.selectById(id);
    }

    @Override
    public ArticleVo getArticleVoById(int id) {
        return articleMapper.getArticleVoById(id);
    }

    @Override
    public int delete(int id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public int updateArt(Article article) {
        return articleMapper.updateById(article);
    }
}
