package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;

import dmacc.beans.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>{

}
