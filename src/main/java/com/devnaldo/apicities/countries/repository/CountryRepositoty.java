package com.devnaldo.apicities.countries.repository;

import com.devnaldo.apicities.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoty  extends JpaRepository<Country, Long> {

}
