package com.flowers.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowers.model.AccountBean;

@Repository
public interface AccountRepository extends JpaRepository<AccountBean, Long>{

}
