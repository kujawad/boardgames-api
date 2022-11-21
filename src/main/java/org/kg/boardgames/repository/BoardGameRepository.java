package org.kg.boardgames.repository;

import org.kg.boardgames.model.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, UUID> {
    Optional<BoardGame> findByPublicId(final String publicId);
}
