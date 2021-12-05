package commentgoodbad.dao;

import java.util.List;

import commentgoodbad.bean.CommentGoodBadDTO;

public interface CommentGoodBadDAO {


	public void commentGood(CommentGoodBadDTO commentGoodBadDTO);

	public void commentBad(CommentGoodBadDTO commentGoodBadDTO);

	public CommentGoodBadDTO checkGoodId(CommentGoodBadDTO commentGoodBadDTO);
	public CommentGoodBadDTO checkBadId(CommentGoodBadDTO commentGoodBadDTO);
	/* List<CommentGoodBadDTO> getCommentGoodBadList(int episodecode); */

	public void commentGoodDelete(CommentGoodBadDTO commentGoodBadDTO);

	public void commentBadDelete(CommentGoodBadDTO commentGoodBadDTO);

}
