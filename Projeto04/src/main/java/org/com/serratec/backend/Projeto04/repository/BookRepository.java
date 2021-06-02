package org.com.serratec.backend.Projeto04.repository;

import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
