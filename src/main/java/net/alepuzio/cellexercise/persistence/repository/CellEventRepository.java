package net.alepuzio.cellexercise.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import net.alepuzio.cellexercise.persistence.CellEvent;

public interface CellEventRepository extends CrudRepository<CellEvent, Integer> {

}
