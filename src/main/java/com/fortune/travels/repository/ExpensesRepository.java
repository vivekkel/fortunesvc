package com.fortune.travels.repository;

import com.fortune.travels.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {

}
