package com.devnaldo.apicities.states.repository;

import com.devnaldo.apicities.states.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository  extends JpaRepository<State, Long>{
}
