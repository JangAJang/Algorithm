package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public void write(Board board, MultipartFile file) throws Exception{ //글 작성
        String projectPath = System.getProperty("user.dir") +"/src/main/resources/static/files";
        UUID uuid = UUID.randomUUID();
        String filename = uuid+"_" + file.getOriginalFilename();
        File savefile = new File(projectPath, filename);
        board.setFilename(filename);
        board.setFilepath("/files/" + filename);
        file.transferTo(savefile);
        boardRepository.save(board);
    }

    public Page<Board> boardList(Pageable pageable){ //게시글 리스트 처리

        return boardRepository.findAll(pageable);
    }

    public Page<Board> boardSearchList(String searchKeyWord, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyWord, pageable);
    }
    public Board boardView(int id){ //특정 게시글 불러오기

        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
