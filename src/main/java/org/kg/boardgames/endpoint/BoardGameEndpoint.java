package org.kg.boardgames.endpoint;

import lombok.AllArgsConstructor;
import org.kg.boardgames.dto.request.BoardGameRateRequest;
import org.kg.boardgames.dto.request.BoardGameRequest;
import org.kg.boardgames.dto.response.BoardGameResponse;
import org.kg.boardgames.service.BoardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = {"/boardgames"})
@AllArgsConstructor
public class BoardGameEndpoint {

    private final BoardGameService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<BoardGameResponse> getAllBoardGames() {
        return service.getAllBoardGames()
                      .stream()
                      .map(boardGame -> new BoardGameResponse(boardGame.getName(), boardGame.getRating()))
                      .toList();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addBoardGame(@Valid @RequestBody final BoardGameRequest request) {
        service.addBoardGame(request);
    }

    @PatchMapping(path = {"/{publicId}/rate"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void rateBoardGame(@PathVariable final String publicId,
                              @Valid @RequestBody final BoardGameRateRequest request) {
        service.rateBoardGame(publicId, request);
    }
}
