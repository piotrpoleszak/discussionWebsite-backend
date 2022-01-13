package com.poleszak.webApp.repository;

import com.poleszak.webApp.model.Subpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubpostRepository extends JpaRepository<Subpost, Long>
{
}
