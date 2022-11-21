package org.kg.boardgames.utils.constraints;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConstraintConstants {

    public static class BoardGame {
        public static final int RATING_MIN_LENGTH = 1;
        public static final int RATING_MAX_LENGTH = 10;

        public static final int NAME_MAX_LENGTH = 32;
        public static final int PUBLIC_ID_MAX_LENGTH = 32;
    }

    public static final class BoardGameRequest extends ConstraintConstants.BoardGame {

    }
}
