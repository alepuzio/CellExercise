package net.alepuzio.cellexercise.persistence;

import org.springframework.data.repository.CrudRepository;

import net.alepuzio.cellexercise.persistence.entity.Cell;

public interface CellRepository extends CrudRepository<Cell, Integer> {

}