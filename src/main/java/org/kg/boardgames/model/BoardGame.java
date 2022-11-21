package org.kg.boardgames.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kg.boardgames.utils.constraints.ConstraintConstants;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "boardgames")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardGame {

    @Id
    @Getter
    @GeneratedValue
    private UUID id;

    @Getter
    @Column(name = "public_id", nullable = false, length = ConstraintConstants.BoardGame.PUBLIC_ID_MAX_LENGTH)
    private String publicId;

    @Getter
    @Column(name = "name", nullable = false, length = ConstraintConstants.BoardGame.NAME_MAX_LENGTH)
    private String name;

    @Getter
    @Column(name = "rating", nullable = false)
    @Min(ConstraintConstants.BoardGame.RATING_MIN_LENGTH)
    @Max(ConstraintConstants.BoardGame.RATING_MAX_LENGTH)
    private Integer rating;

    @Getter
    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @Getter
    @Column(name = "modification_date", nullable = false)
    private Instant modificationDate;

    public void rate(final int rating) {
        this.rating = rating;
    }

    public static class Builder {
        private final BoardGame instance = new BoardGame();

        public Builder withName(final String name) {
            instance.name = name;
            return this;
        }

        public Builder withRating(final Integer rating) {
            instance.rating = rating;
            return this;
        }

        public BoardGame build() {
            instance.publicId = BoardGamePublicIdGenerator.generate();
            instance.creationDate = Instant.now();
            instance.modificationDate = instance.creationDate;
            return instance;
        }
    }
}
