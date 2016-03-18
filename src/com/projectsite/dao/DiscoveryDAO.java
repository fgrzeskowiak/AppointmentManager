package com.projectsite.dao;
 
import java.util.List;
 
import com.projectsite.model.Discovery;
 
public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{
 
    List<Discovery> getAll();
     
}