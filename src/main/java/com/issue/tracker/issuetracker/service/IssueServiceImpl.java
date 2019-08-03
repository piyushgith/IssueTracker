package com.issue.tracker.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issue.tracker.issuetracker.entity.Issue;
import com.issue.tracker.issuetracker.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueRepository issueRepository;

	@Override
	public List<Issue> findAllIssue() {
		return (List<Issue>) issueRepository.findAll();
	}

	@Override
	public void saveIssue(Issue iss) {
		issueRepository.save(iss);
	}

	@Override
	public Issue changeStatus(Issue iss) {
		return issueRepository.save(iss);
	}

	@Override
	public void deleteIssue(long id) {
		issueRepository.deleteById(id);
	}

}
