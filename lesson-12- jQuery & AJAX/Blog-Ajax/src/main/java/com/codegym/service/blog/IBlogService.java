package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findByTitleContaining(String keyword);
    Iterable<Blog> loadMoreBlogs(int page, int pageSize);

}
