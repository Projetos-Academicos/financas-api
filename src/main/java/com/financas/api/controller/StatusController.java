package com.financas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.api.model.Status;
import com.financas.api.service.StatusService;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService service;

	@GetMapping
	public List<Status> listar(){
		return this.service.listar();
	}
}
