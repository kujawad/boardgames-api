package org.kg.boardgames.model.factory;

import org.kg.boardgames.dto.request.BoardGameRequest;
import org.kg.boardgames.model.BoardGame;

public final class BoardGameFactory {

    public static BoardGame create(final BoardGameRequest request) {
        return new BoardGame.Builder().withName(request.getName())
                                      .withRating(request.getRating())
                                      .build();
    }
}
