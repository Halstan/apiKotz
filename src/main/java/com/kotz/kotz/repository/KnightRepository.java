package com.kotz.kotz.repository;

import com.kotz.kotz.entity.Knight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KnightRepository extends JpaRepository<Knight, Long> {

    @Query(value = "SELECT id_knight, knight.name, constellation, knight.url_photo, hability1, hability2, hability3, hability4, armor_id_armor, god_id_god from " +
            "knight INNER JOIN god on knight.god_id_god = god.id_god where god.name = :name", nativeQuery = true)
    List<Knight> findKnightByGod(@Param("name") String name);


    @Query(value = "SELECT id_knight, knight.name, constellation, url_photo, hability1, hability2, hability3, hability4, armor_id_armor, god_id_god from " +
            "knight INNER JOIN type_armor on knight.armor_id_armor = type_armor.id_armor where type_armor.name_armor = :armor", nativeQuery = true)
    List<Knight> findKnightByArmor(@Param("armor") String armor);

    @Query(value = "SELECT * FROM knight ORDER BY random() LIMIT 1", nativeQuery = true)
    //@Query(value = "SELECT * FROM Knight ORDER BY rand() LIMIT 1", nativeQuery = true)
    Knight getRandomKnight();

    List<Knight> getKnightsByNameStartsWith(String name);

}
