package edu.hziee.mappers;

import java.util.List;

import edu.hziee.models.Blog;

public interface BlogMapper {
	int insertBlog(Blog blog);
	Blog selectBlog(int id);
	void deleteBlog(int id);
	void updateBlog(Blog blog);
	List<Blog> selectBlogs();
}
