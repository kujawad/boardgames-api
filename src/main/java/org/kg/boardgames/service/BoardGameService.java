package org.kg.boardgames.service;

import lombok.AllArgsConstructor;
import org.kg.boardgames.dto.request.BoardGameRateRequest;
import org.kg.boardgames.dto.request.BoardGameRequest;
import org.kg.boardgames.model.BoardGame;
import org.kg.boardgames.model.factory.BoardGameFactory;
import org.kg.boardgames.repository.BoardGameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardGameService {

    private final BoardGameRepository repository;

    @Transactional
    public void addBoardGame(final BoardGameRequest request) {
        repository.save(BoardGameFactory.create(request));
    }

    @Transactional
    public void rateBoardGame(final String publicId, final BoardGameRateRequest request) {
        final BoardGame boardGame = repository.findByPublicId(publicId)
                                              .orElseThrow(() -> new RuntimeException("BoardGameDoesNotExists"));
        boardGame.rate(request.getRating());
        repository.save(boardGame);
    }

    public List<BoardGame> getAllBoardGames() {
        return repository.findAll();
    }
}
