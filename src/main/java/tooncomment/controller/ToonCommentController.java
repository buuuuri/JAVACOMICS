package tooncomment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import commentgoodbad.bean.CommentGoodBadDTO;
import commentgoodbad.service.CommentGoodBadService;
import tooncomment.bean.ToonCommentDTO;
import tooncomment.service.ToonCommentService;
import webtoon.bean.WebtoonDTO;

@Controller
@RequestMapping(value = "/tooncomment")
public class ToonCommentController {
	@Autowired
	private ToonCommentService toonCommentService; 

	@RequestMapping(value="/toonCommentWrite", method=RequestMethod.POST)
	@ResponseBody
	public void toonCommentWrite(@ModelAttribute ToonCommentDTO toonCommentDTO) {
		toonCommentService.toonCommentWrite(toonCommentDTO);
	}

	/*@RequestMapping(value="/getToonCommentList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getToonCommentList(@RequestParam int episodecode) { 
		
		List<ToonCommentDTO> list1 = toonCommentService.getToonCommentList(episodecode);
		//List<CommentGoodBadDTO> list2 = commentGoodBadService.getCommentGoodBadList(episodecode);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("list1", list1);
		//mav.addObject("list2", list2);
		mav.setViewName("jsonView");
	
		return mav;
	}*/
	@PostMapping(value="getToonCommentList")
	@ResponseBody
	public List<ToonCommentDTO> getToonCommentList(@RequestParam int episodecode){
		return toonCommentService.getToonCommentList(episodecode);
	}
	/*
	 * @GetMapping(value = "/list") public String list() { return "/user/list"; }
	 */
	
}
