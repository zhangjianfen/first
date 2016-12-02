package edu.hziee.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hziee.dao.BlogDao;
import edu.hziee.models.Blog;

@Controller
@Transactional
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogDao blogDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getBlogs(){
		ModelAndView mav = new ModelAndView("/blog/blogs");
		List<Blog> blogs = blogDao.selectBlogs();
		mav.addObject("blogs", blogs);
		return mav;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView getBlog(@PathVariable int id, HttpServletRequest r){
		ModelAndView mav = new ModelAndView("/blog/blog");
		Blog blog = blogDao.selectBlog(id);
		
		mav.addObject("blog", blog);
		return mav;
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView addBlog(){
		ModelAndView mav = new ModelAndView("/blog/addBlog");
		return mav;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public ModelAndView addBlog(@RequestParam String title,
			@RequestParam String author,@RequestParam String content){
		ModelAndView mav = new ModelAndView();
		
		Blog blog = new Blog();
		blog.setAuthor(author);
		blog.setContent(content);
		blog.setTitle(title);
		blogDao.insertBlog(blog);
		
		mav.setViewName("redirect:/blog");
		return mav;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView deleteBlog(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		
		blogDao.deleteBlog(id);
		mav.setViewName("redirect:/blog");
		
		return mav;
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView editBlog(@RequestParam int id){
		ModelAndView mav = new ModelAndView("/blog/editBlog");
		Blog blog = blogDao.selectBlog(id);
		mav.addObject("blog", blog);
		return mav;
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public ModelAndView editBlog(@RequestParam int id,
			@RequestParam String title, @RequestParam String content, 
			@RequestParam String author){
		ModelAndView mav = new ModelAndView();
		Blog blog = new Blog();
		blog.setId(id);
		blog.setAuthor(author);
		blog.setContent(content);
		blog.setTitle(title);
		
		blogDao.updateBlog(blog);
		mav.setViewName("redirect:/blog");
		return mav;
	}
}
