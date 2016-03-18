package com.projectsite.dao;
 
import com.projectsite.model.Vote;
 
public interface VoteDAO extends GenericDAO<Vote, Long> {
 
    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);
}