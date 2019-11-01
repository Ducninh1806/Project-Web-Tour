package com.ducninh.repository;

import com.ducninh.model.Tour;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TourRepository extends PagingAndSortingRepository<Tour ,Long> {
}
