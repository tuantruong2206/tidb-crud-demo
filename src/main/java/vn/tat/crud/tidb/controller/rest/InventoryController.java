package vn.tat.crud.tidb.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.tat.crud.tidb.domain.model.Product;
import vn.tat.crud.tidb.dto.JsonResponse;
import vn.tat.crud.tidb.dto.ProductFullDTO;
import vn.tat.crud.tidb.service.ProductService;
import vn.tat.crud.tidb.util.HeaderUtil;
import vn.tat.crud.tidb.validation.ProductValidator;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * All REST APIs of Inventory.
 */
@RestController
@RequestMapping(path = "inventory", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {

    private final Logger log = LoggerFactory.getLogger(InventoryController.class);

    private final ProductService productService;

    private static final String ENTITY_NAME = "product";

    public InventoryController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get product item by Id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<JsonResponse<ProductFullDTO>> getProductById(@PathVariable Long id) throws Exception {
        log.info("REST request to get product: {} new change", id);
        return new ResponseEntity<>(new JsonResponse<>(this.productService.getProductById(id)), HttpStatus.OK);
    }

    /**
     * create product Item
     * @param product
     * @param bindingResult
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/products")
    public ResponseEntity<JsonResponse<Product>> createNewProduct(@Valid @RequestBody Product product, BindingResult bindingResult) throws URISyntaxException {
        ProductValidator.validate(bindingResult);
        log.info("REST request to update Product: {}", product);
        product = this.productService.save(product);
        return ResponseEntity.created(new URI("/inventory/product/" + product.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, product.getId().toString()))
                .body(new JsonResponse<>(product));
    }

    /**
     * delete product Item by id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<JsonResponse<Object>> deleteProduct(@PathVariable Long id) {
        log.info("REST request to update Product: {}", id);
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString()))
                .body(new JsonResponse<>());
    }

    /**
     * create product Item
     * @param product
     * @param bindingResult
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/products-custom")
    public ResponseEntity<Product> myCreateNewProduct(@Valid @RequestBody Product product, BindingResult bindingResult) throws URISyntaxException {
        log.info("REST request to update Product: {}", product);
        ProductValidator.validate(bindingResult);
        product = this.productService.save(product);
        return ResponseEntity.created(new URI("/inventory/product/" + product.getId()))
                .body(product);
    }

//    https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
//
//    @GetMapping("/tutorials")
//    public ResponseEntity<List<Tutorial>>
//              ...
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    GET GET GET GET GET GET GET GET GET GET GET GET
//    @GetMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
//        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    POST POST POST POST POST POST POST POST POST POST POST POST
//    @PostMapping("/tutorials")
//    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//        try {
//            Tutorial _tutorial = tutorialRepository
//                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT PUT
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//        if {
//            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    DELETE DELETE DELETE
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//        try {
//            tutorialRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/tutorials")
//    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//        try {
//            tutorialRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

}
