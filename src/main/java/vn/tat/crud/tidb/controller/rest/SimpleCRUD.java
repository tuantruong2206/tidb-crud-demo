package vn.tat.crud.tidb.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.tat.crud.tidb.dto.TutorialDTO;

import java.util.Arrays;
import java.util.List;

/**
 * All REST APIs of Inventory.
 */
@RestController
@RequestMapping(path = "simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleCRUD {

    private final Logger log = LoggerFactory.getLogger(SimpleCRUD.class);

    @GetMapping("/tutorials")
    public ResponseEntity<List<TutorialDTO>> getListTutorials() {
        List<TutorialDTO> lst = Arrays.asList(new TutorialDTO(1L, "iphone 1", 1.1, "GREEN"),
                new TutorialDTO(2L, "iphone 2", 1.5, "GREEN"),
                new TutorialDTO(3L, "iphone 3", 2.5, "YELLOW"),
                new TutorialDTO(4L, "iphone 4", 3.5, "RED"));

        return new ResponseEntity<>(lst, HttpStatus.OK);

    }

    @PostMapping("tutorials")
    public ResponseEntity<TutorialDTO> createNewTutorial(@RequestBody TutorialDTO tu) {

        return new ResponseEntity<>(tu, HttpStatus.CREATED);

    }

    @DeleteMapping("tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
        log.info("Delete ID {}change some thing", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("tutorials")
    public ResponseEntity<TutorialDTO> updateTutorial(@RequestBody TutorialDTO tu) {
        tu.setName("Modified !!! 234");
        return new ResponseEntity<>(tu, HttpStatus.OK);
        //EXCEPTION
//         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
