package edu.hziee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hziee.mappers.BlogMapper;
import edu.hziee.models.Blog;

@Repository
public class BlogDao {
	
	@Autowired //自动注入
	private BlogMapper blogMapper;
	
	public void insertBlog(Blog blog){
		blogMapper.insertBlog(blog);
	}
	
	public Blog selectBlog(int id){
		return blogMapper.selectBlog(id);
	}
	
	public List<Blog> selectBlogs(){
		return blogMapper.selectBlogs();
	}
	
	public void updateBlog(Blog blog){
		blogMapper.updateBlog(blog);
	}
	
	public void deleteBlog(int id){
		blogMapper.deleteBlog(id);
	}
}
