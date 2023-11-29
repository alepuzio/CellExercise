package net.alepuzio.cellexercise.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.alepuzio.cellexercise.persistence.entity.Cell;

@Repository
public interface CellRepository extends CrudRepository<Cell, Integer> {

}