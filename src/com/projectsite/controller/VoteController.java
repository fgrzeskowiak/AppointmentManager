package com.projectsite.controller;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.projectsite.model.Discovery;
import com.projectsite.model.User;
import com.projectsite.model.Vote;
import com.projectsite.model.VoteType;
import com.projectsite.service.DiscoveryService;
import com.projectsite.service.VoteService;
 
/**
 * example URL /vote?discovery_id=3&vote=VOTE_UP
 */
@WebServlet("/vote")
public class VoteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("user");
        if(loggedUser != null) {
            VoteType voteType = VoteType.valueOf(request.getParameter("vote"));
            long userId  = loggedUser.getId();
            long discoveryId = Long.parseLong(request.getParameter("discovery_id"));
            updateVote(userId, discoveryId, voteType, request);
        }
        response.sendRedirect(request.getContextPath());
    }
 
    private void updateVote(long userId, long discoveryId, VoteType voteType, HttpServletRequest request) {
    	boolean vote = false;
        VoteService voteService = new VoteService();
        Vote existingVote = voteService.getVoteByDiscoveryUserId(discoveryId, userId);
        Vote updatedVote = voteService.addOrUpdateVote(discoveryId, userId, voteType);
        if(existingVote != updatedVote || !updatedVote.equals(existingVote)) {
            updateDiscovery(discoveryId, existingVote, updatedVote);
        } else {
        	vote = true;
        	request.setAttribute("voteExists", vote);
        }
    }
 
    private void updateDiscovery(long discoveryId, Vote oldVote, Vote newVote) {
        DiscoveryService discoveryService = new DiscoveryService();
        Discovery discoveryById = discoveryService.getDiscoveryById(discoveryId);
        Discovery updatedDiscovery = null;
        if(oldVote == null && newVote != null) {
            updatedDiscovery = addDiscoveryVote(discoveryById, newVote.getVoteType());
        } else if(oldVote != null && newVote != null) {
            updatedDiscovery = removeDiscoveryVote(discoveryById, oldVote.getVoteType());
            updatedDiscovery = addDiscoveryVote(updatedDiscovery, newVote.getVoteType());
        }
        discoveryService.updateDiscovery(updatedDiscovery);
    }
     
    private Discovery addDiscoveryVote(Discovery discovery, VoteType voteType) {
        Discovery discoveryCopy = new Discovery(discovery);
        if(voteType == VoteType.VOTE_UP) {
            discoveryCopy.setUpVote(discoveryCopy.getUpVote() + 1);
        } else if(voteType == VoteType.VOTE_DOWN) {
            discoveryCopy.setDownVote(discoveryCopy.getDownVote() + 1);
        }
        return discoveryCopy;
    }
     
    private Discovery removeDiscoveryVote(Discovery discovery, VoteType voteType) {
        Discovery discoveryCopy = new Discovery(discovery);
        if(voteType == VoteType.VOTE_UP) {
            discoveryCopy.setUpVote(discoveryCopy.getUpVote() - 1);
        } else if(voteType == VoteType.VOTE_DOWN) {
            discoveryCopy.setDownVote(discoveryCopy.getDownVote() - 1);
        }
        return discoveryCopy;
    }
}