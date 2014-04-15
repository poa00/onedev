package com.pmease.gitop.web.page.project.pullrequest.activity;

import java.util.Date;

import org.apache.wicket.markup.html.panel.Panel;

import com.pmease.gitop.model.User;
import com.pmease.gitop.model.Vote;

public class VotePullRequest implements PullRequestActivity {

	private final Vote vote;
	
	public VotePullRequest(Vote vote) {
		this.vote = vote;
	}
	
	@Override
	public Panel render(String panelId) {
		return new VoteActivityPanel(panelId, new VoteModel(vote.getId()));
	}

	@Override
	public Date getDate() {
		return vote.getDate();
	}

	@Override
	public User getUser() {
		return vote.getVoter();
	}

	@Override
	public String getAction() {
		if (vote.getResult() == Vote.Result.APPROVE)
			return "Approved";
		else
			return "Disapproved";
	}

}
