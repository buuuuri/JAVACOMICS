package tooncomment.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tooncomment.bean.ToonCommentDTO;
import tooncomment.service.ToonCommentService;

@Controller
@RequestMapping(value = "tooncomment")
public class ToonCommentController {
	@Autowired
	private ToonCommentService toonCommentService; 

	@RequestMapping(value="toonCommentWrite", method=RequestMethod.POST)
	@ResponseBody
	public void toonCommentWrite(@ModelAttribute ToonCommentDTO toonCommentDTO
								,@RequestParam String episodeCode,HttpSession session) {
		String id = (String) session.getAttribute("toonMemId");
		toonCommentDTO.setId(id);
		toonCommentDTO.setEpisodeCode(Integer.parseInt(episodeCode));
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
/*	@PostMapping(value="getToonCommentList")
	@ResponseBody
	public ModelAndView getToonCommentList(ToonCommentDTO toonCommentDTO, @RequestParam int episodecode, HttpSession session){
		String id =(String)session.getAttribute("toonMemId");
		List<ToonCommentDTO> list = toonCommentService.getToonCommentList(episodecode);
		ModelAndView mav = new ModelAndView();
			mav.addObject("list", list);
			mav.addObject("id", id);

			return mav;
	
	}*/
	
	@PostMapping(value="getToonCommentList")
	@ResponseBody
	public List<ToonCommentDTO> getToonCommentList(@RequestParam String episodeCode){
		int episodecode=Integer.parseInt(episodeCode);
		return toonCommentService.getToonCommentList(episodecode);
	}
	
	@PostMapping(value="sortLatest")
	@ResponseBody
	public List<ToonCommentDTO> sortLatest(@RequestParam String episodeCode){
		int episodecode=Integer.parseInt(episodeCode);
		return toonCommentService.sortLatest(episodecode);
	}
	/*
	 * @GetMapping(value = "/list") public String list() { return "/user/list"; }
	 */
	
	@PostMapping(value="getCommentGood")
	@ResponseBody
	public ToonCommentDTO getCommentGood(@RequestParam int commentSeq){
		return toonCommentService.getCommentGood(commentSeq);
	}
	
	@PostMapping(value="getToonCommentCount")
	@ResponseBody
	public int getToonCommentCount(@RequestParam String episodeCode){
		int episodecode=Integer.parseInt(episodeCode);
		return toonCommentService.getToonCommentCount(episodecode);
	}
	
}
