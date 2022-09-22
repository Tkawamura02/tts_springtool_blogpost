package com.techtalentsouth.TechTalentBlog.BlogPost;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	//In memory copy of the database.
	private List<BlogPost> posts = new ArrayList<>(); 
	
	@GetMapping(path="/")	
	public String index(Model model) {

		model.addAttribute("posts", posts);
		return "blogpost/index";
	}

	@GetMapping(path="/blogposts/new")
	public String newBlog(Model model) {
		return "blogpost/new";
	}
	
	@PostMapping(path="/blogposts")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);	
		posts.add(blogPost);
		
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
	
	@RequestMapping(value = "/blogposts/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {

	    blogPostRepository.deleteById(id);
	    return "blogpost/index";

	}
	
		
}
