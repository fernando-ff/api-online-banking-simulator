package br.edu.ufrn.core.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.ufrn.core.model.Course;

/**
 * @author William Suane
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
