package com.issue.tracker.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.issue.tracker.issuetracker.entity.Issue;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {

}
