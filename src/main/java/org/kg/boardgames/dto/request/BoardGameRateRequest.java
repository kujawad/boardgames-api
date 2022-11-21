package org.kg.boardgames.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.kg.boardgames.utils.constraints.ConstraintConstants;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class BoardGameRateRequest {

    @NotNull
    @Min(ConstraintConstants.BoardGameRequest.RATING_MIN_LENGTH)
    @Max(ConstraintConstants.BoardGameRequest.RATING_MAX_LENGTH)
    private final int rating;
}
