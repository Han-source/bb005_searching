package www.dream.com.bulletinBoard.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.com.bulletinBoard.dto.PostCriteria;
import www.dream.com.bulletinBoard.model.BoardVO;
import www.dream.com.bulletinBoard.model.PostVO;
import www.dream.com.bulletinBoard.persistence.PostMapper;
import www.dream.com.common.dto.Criteria;

@Service
public class PostService {

   @Autowired
   private PostMapper postMapper;
   
   
   //LRCUD
   public long getTotalCount(int boardId) {
      return postMapper.getTotalCount(boardId);
   }

   /* mapper 함수의 인자 개수가 여러개 일때는 필수적으로 @Param을 넣어야 한다.
    * 이를 실수하지 않기 위하여 한개여도 그냥 명시적으로 넣어 주세요*/
   public List<PostVO> getList(int boardId, Criteria cri){
      return postMapper.getList(boardId, cri);
   }
   
   public long getTotalCountBySearch(int boardId, PostCriteria cri) {
      return postMapper.getTotalCountBySearch(boardId, cri);
   }
   
   public List<PostVO> getListBySearchWithPaging(int boardId, PostCriteria cri){
      return postMapper.getListBySearchWithPaging(boardId, cri);
   }
   
   
   /** id 값으로 Post 객체 조회*/
   public PostVO findPostById(String id) {
      return postMapper.findPostById(id);
   }
   
   
   public int insert(BoardVO board, PostVO post) {
      return postMapper.insert(board, post);
   }
   
   /** 게시글 수정 처리*/
   public boolean updatePost(PostVO post) {
      return postMapper.updatePost(post) == 1;
   }
   
   /** id 값으로 Post 객체 삭제*/

   public boolean deletePostById(String id) {
      
      return postMapper.deletePostById(id) == 1;
   }
      
   
}