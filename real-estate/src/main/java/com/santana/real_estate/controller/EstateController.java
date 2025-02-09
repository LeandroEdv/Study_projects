package com.santana.real_estate.controller;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.EstatePutRequestBody;
import com.santana.real_estate.service.estateservice.EstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/estate")
public class EstateController {

    private final EstateService estateService;

    @GetMapping
    public ResponseEntity<Page<Estate>> listAll(Pageable pageable) {
        return new ResponseEntity<>(estateService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<Page<Estate>> findByCategory(@PathVariable String category, Pageable pageable) {
        return new ResponseEntity<>(estateService.findByCategory(category, pageable), HttpStatus.OK);
    }

    @GetMapping("/{category}/{transactionType}")
    public ResponseEntity<Page<Estate>> findByCategoryAndTransactionType(@PathVariable String category,
                                                                         @PathVariable String transactionType,
                                                                         Pageable pageable) {
        return new ResponseEntity<>(estateService
                .findByCategoryAndTransactionType(category, transactionType, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estate> save(@RequestBody EstatePostRequestBody estatePostRequestBody) {
        return new ResponseEntity<>(estateService.save(estatePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        estateService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody EstatePutRequestBody estatePutRequestBody) {
        estateService.replace(estatePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


