package it.interlogic.vimp.data.jpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import it.interlogic.vimp.data.jpa.model.PLFTAreeCompetenzaEntity;
import it.interlogic.vimp.data.jpa.model.PLFTMacroareaServiziEntity;

public interface PLFTMacroareaServiziJpaRepository extends PagingAndSortingRepository<PLFTMacroareaServiziEntity, BigDecimal> {

	@Query(value = "SELECT m FROM PLFTMacroareaServiziEntity m WHERE dataFine IS NULL")
	List<PLFTMacroareaServiziEntity> findMacroareeServizi();
	
	
	
	@Query(value = "SELECT tipo from PLFTMacroareaServiziEntity tipo where tipo.descrizione = :descrizione")
	public abstract List<PLFTMacroareaServiziEntity> findMacroareeServiziPerDescrizione(@Param("descrizione") String descrizione);

}
