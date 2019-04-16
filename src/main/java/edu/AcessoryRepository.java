package edu;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoryRepository extends CrudRepository<Accessory, Integer> {
}
