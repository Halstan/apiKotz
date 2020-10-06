package com.kotz.kotz.repository;

import com.kotz.kotz.entity.TypeArmor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepository extends JpaRepository<TypeArmor, Long> {
}
