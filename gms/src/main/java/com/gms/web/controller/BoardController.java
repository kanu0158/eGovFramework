package com.gms.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.domain.ArticleDTO;
import com.gms.web.domain.MemberDTO;
import com.gms.web.service.BoardService;
import com.gms.web.service.MemberService;
@Controller
@RequestMapping("/board")
public class BoardController {
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired ArticleDTO article;
	@Autowired BoardService boardService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("article") ArticleDTO article) {
		logger.info("BoardController ::: add ");
		/*System.out.println("name is "+board.getName());
		SDAS
		System.out.println("--------------------------------------");
		System.out.println(member.getUserId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		System.out.println(member.getSsn());
		System.out.println(member.getTeamId());
		System.out.println(member.getRoll());
		System.out.println(member.getSubject());*/
		boardService.add(article);
		return "auth:member/login.tiles";
	}
	@RequestMapping("/list")
	public void list() {
		
	}
	@RequestMapping("/search")
	public void search() {
		
	}
	@RequestMapping("/retrieve")
	public void retrieve(@ModelAttribute("article") ArticleDTO article) {
		
	}
	@RequestMapping("/count")
	public void count() {
		
	}
	@RequestMapping("/modify")
	public String modify(@ModelAttribute("article") ArticleDTO article,
			Model model) {
		logger.info("BoardController ::: modify ");
		/*System.out.println("---userId : "+member.getUserId());
		System.out.println("---password : "+member.getPassword());
		System.out.println("---name : "+member.getName());
		System.out.println("---teamId : "+member.getTeamId());
		System.out.println("---roll : "+member.getRoll());*/
		boardService.modify(article);
		model.addAttribute("user",boardService.retrieve(article));
		return "user:member/retrieve.tiles";
	}
	@RequestMapping("/remove")
	public String remove(@ModelAttribute("article") ArticleDTO article) {
		logger.info("BoardController ::: remove ");
		/*System.out.println("---userId : "+article.getUserId());
		System.out.println("---password : "+article.getPassword());*/
		boardService.remove(article);
		return "redirect:/";
	}
	
	@RequestMapping("/fileupload")
	public void fileupload() {
		
	}
}
