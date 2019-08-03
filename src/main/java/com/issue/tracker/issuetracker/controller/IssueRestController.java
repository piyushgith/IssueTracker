package com.issue.tracker.issuetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issue.tracker.issuetracker.entity.Issue;
import com.issue.tracker.issuetracker.service.IssueService;

@RestController
@RequestMapping("/")
public class IssueRestController {
	
	@Autowired
	private IssueService issueService;

	@GetMapping("hi")
	public String sayHello() {
		return "Hi There !";
	}

	@RequestMapping(value = "getIssues", method = RequestMethod.GET)
	public ResponseEntity<List<Issue>> getAllIssues() {
		return new ResponseEntity<List<Issue>>(issueService.findAllIssue(), HttpStatus.OK);
	}
	
	//Correct Way to create json body ID is not needed in case of Post request
	/*{	"id":1L,"category":"UI Issue","description":"Need CSS in page",	"status":"New",	"priority":1L}*/
	@RequestMapping(value = "saveIssue", method = RequestMethod.POST)
	public ResponseEntity<Void> saveIssue(@RequestBody Issue issue) {
		issueService.saveIssue(issue);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
