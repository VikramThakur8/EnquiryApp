package net.ezeon.poc.repo;

import net.ezeon.poc.domain.EnquirySource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vikram
 */
public interface EnquirySourceRepository extends JpaRepository<EnquirySource, Long>{
    
}
