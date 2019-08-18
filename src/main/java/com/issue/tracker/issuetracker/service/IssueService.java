/**
 * 
 */
package com.issue.tracker.issuetracker.service;

import java.util.List;
import java.util.Optional;

import com.issue.tracker.issuetracker.entity.Issue;

/**
 * @author INSPIRON
 *
 */
public interface IssueService {

	List<Issue> findAllIssue();

	void saveIssue(Issue iss);

	Issue changeStatus(Issue iss);
	
	void deleteIssue(long id);
	
	Optional<Issue> searchIssueById(long id);
}
