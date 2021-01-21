package com.modelingorders.demo.services;

import com.modelingorders.demo.models.Agent;
import com.modelingorders.demo.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentsService")
public class AgentsServiceImpl implements AgentsServices
{
    @Autowired
    private AgentsRepository agentsRepository;

    @Override
    public Agent findAgentById(long id) throws EntityNotFoundException
    {
        return agentsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Agent Id " + id + " Not Found"));
    }
}
