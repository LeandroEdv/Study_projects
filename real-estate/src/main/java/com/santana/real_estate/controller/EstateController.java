package com.santana.real_estate.controller;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.EstatePutRequestBody;
import com.santana.real_estate.service.estateservice.EstateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("estate")
public class EstateController {

    private final EstateService estateService;

    @Operation(summary = "List all Estate paginated", tags = "estate-list")
    @GetMapping(path = "find")
    public ResponseEntity<Page<Estate>> listAll(@ParameterObject Pageable pageable) {
        return new ResponseEntity<>(estateService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "List all Estate paginated by category", tags = "estate-list")
    @GetMapping(path = "find/{category}")
    public ResponseEntity<Page<Estate>> findByCategory(@PathVariable String category, @ParameterObject Pageable pageable) {
        return new ResponseEntity<>(estateService.findByCategory(category, pageable), HttpStatus.OK);
    }

    @Operation(summary = "List all Estate paginated by category and transaction type", tags = "estate-list")
    @GetMapping(path = "find/{category}/{transactionType}")
    public ResponseEntity<Page<Estate>> findByCategoryAndTransactionType(@PathVariable String category,
                                                                         @PathVariable String transactionType,
                                                                         @ParameterObject Pageable pageable) {
        return new ResponseEntity<>(estateService
                .findByCategoryAndTransactionType(category, transactionType, pageable), HttpStatus.OK);
    }

    @Operation(summary = "Save Estate")
    @PostMapping
    public ResponseEntity<Estate> save(@RequestBody EstatePostRequestBody estatePostRequestBody) {
        return new ResponseEntity<>(estateService.save(estatePostRequestBody), HttpStatus.CREATED);
    }

    @Operation(summary = "Delete Estate")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        estateService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update Estate")
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody EstatePutRequestBody estatePutRequestBody) {
        estateService.replace(estatePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


