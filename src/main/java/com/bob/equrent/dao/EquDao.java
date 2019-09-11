package com.bob.equrent.dao;

import com.bob.equrent.entity.Equ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquDao extends JpaRepository<Equ,Integer> {
}
