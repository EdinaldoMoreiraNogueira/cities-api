package com.devnaldo.apicities.countries;

import com.devnaldo.apicities.countries.Country;
import com.devnaldo.apicities.countries.repository.CountryRepositoty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryResource {


    // Dependency injection
    private CountryRepositoty repository;
    private CountryResource(CountryRepositoty repository){
        this.repository = repository;
    }


    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){

        return Optional
                .ofNullable(repository.findById(id).get())
                .map(foundCountry -> ResponseEntity.ok().body(foundCountry))
                .orElseGet( () -> ResponseEntity.notFound().build());

    }
}
