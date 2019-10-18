package com.mauriciopd.carstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauriciopd.carstore.domain.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer>{

	Optional<Picture> findByFileName(String fileName);
}
