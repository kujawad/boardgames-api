package org.kg.boardgames.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.kg.boardgames.utils.constraints.ConstraintConstants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class BoardGameRequest {

    @NotNull
    @NotEmpty
    @Length(max = ConstraintConstants.BoardGameRequest.NAME_MAX_LENGTH)
    private final String name;


    @Range(min = ConstraintConstants.BoardGameRequest.RATING_MIN_LENGTH,
           max = ConstraintConstants.BoardGameRequest.RATING_MAX_LENGTH)
    private final int rating;
}
