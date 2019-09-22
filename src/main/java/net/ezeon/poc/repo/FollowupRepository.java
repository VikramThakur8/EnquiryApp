/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.poc.repo;

import java.util.List;
import net.ezeon.poc.domain.Followup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Vikram
 */
public interface FollowupRepository extends JpaRepository<Followup, Long> {

    @Query("SELECT new Followup(f.followupId, f.doe, f.detail) FROM Followup as f WHERE f.enquiry.enquiryId=?1 ORDER BY f.doe desc")
    List<Followup> getFollowupsByEnquiryId(Long enquiryId);
}
