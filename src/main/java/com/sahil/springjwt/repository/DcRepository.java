package com.sahil.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Dc;

public interface DcRepository extends JpaRepository<Dc, Long>{

	List<Dc> findByUsersId(long usersId);
}
