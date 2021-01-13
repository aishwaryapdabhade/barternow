package com.acrux.barternow.repository;

import com.acrux.barternow.domain.CustomerDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CustomerDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
