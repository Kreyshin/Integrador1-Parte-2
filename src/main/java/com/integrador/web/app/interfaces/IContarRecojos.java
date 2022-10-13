package com.integrador.web.app.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.integrador.web.app.model.IRecojoGroupByMotorizado;
import com.integrador.web.app.model.Recojo;

import java.util.List;

public interface IContarRecojos extends JpaRepository<Recojo, Integer> {

	

}
