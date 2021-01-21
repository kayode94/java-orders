package com.modelingorders.demo.repositories;

import com.modelingorders.demo.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long>
{

}
