package com.example.reactboard.db;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    /*
           mapper xml 파일의 resultType 해당하는 클래스에 결과를 담고,
           n개가 되므로 MutableList 로 return 타입을 설정.
     */

    List<BoardEntity> getBoardList(HashMap<String , Object> paramMap);

    Integer getBoardTotalCount(HashMap<String, Object> paramMap);

    BoardEntity getBoardOne(Long idx);

    int insertBoard(BoardEntity entity);

    int updateBoard(BoardEntity entity);

    int deleteBoard(Long idx);
}
