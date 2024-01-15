package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.blog.BlogService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BlogServiceTest {
    @Test
    public void testFindAll() {
        IBlogRepository blogRepository = Mockito.mock(IBlogRepository.class);

        List<Blog> mockBlogs = new ArrayList<>();
        mockBlogs.add(new Blog(1L,"Title 1", "Content 1", "Image 1", new Category(1L,"abc")));
        mockBlogs.add(new Blog(2L,"Title 2", "Content 2", "Image 2", new Category(2L,"bcd")));

        when(blogRepository.findAll()).thenReturn(mockBlogs);

        BlogService blogService = new BlogService(blogRepository);

        assertEquals(mockBlogs, blogService.findAll());
    }

    @Test
    public void testFindById() {
        IBlogRepository blogRepository = Mockito.mock(IBlogRepository.class);

        Blog mockBlog = new Blog(1L,"Title 1", "Content 1", "Image 1", new Category(1l,"abc"));

        when(blogRepository.findById(1L)).thenReturn(Optional.of(mockBlog));

        BlogService blogService = new BlogService(blogRepository);

        assertEquals(Optional.of(mockBlog), blogService.findById(1L));
    }
    @Test
    public void testFindAllPaged(){
        IBlogRepository blogRepository = Mockito.mock(IBlogRepository.class);
        List<Blog> mockBlogs = new ArrayList<>();
        mockBlogs.add(new Blog(1L,"Title 1", "Content 1", "Image 1", new Category(1L,"abc")));
        mockBlogs.add(new Blog(2L,"Title 2", "Content 2", "Image 2", new Category(2L,"bcd")));
        Page<Blog> mockPage = new PageImpl<>(mockBlogs);
        when(blogRepository.findAll(PageRequest.of(0, 5))).thenReturn(mockPage);
        BlogService blogService = new BlogService(blogRepository);
        assertEquals(mockPage, blogService.findAll(PageRequest.of(0, 5)));
    }
    @Test
    public void testFindByNameContaining(){
        IBlogRepository blogRepository = Mockito.mock(IBlogRepository.class);
        List<Blog> mockBlogs = new ArrayList<>();
        mockBlogs.add(new Blog(1L,"Title 1", "Content 1", "Image 1", new Category(1L,"abc")));
        mockBlogs.add(new Blog(2L,"Title 2", "Content 2", "Image 2", new Category(2L,"bcd")));
        when(blogRepository.findByNameContaining("Title")).thenReturn(mockBlogs);
        BlogService blogService = new BlogService(blogRepository);
        assertEquals(mockBlogs,blogService.findByNameContaining("Title"));
    }
}
