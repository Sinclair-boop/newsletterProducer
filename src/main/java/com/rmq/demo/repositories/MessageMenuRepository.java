package com.rmq.demo.repositories;

import com.rmq.demo.models.MessageMenu;
import org.springframework.data.repository.CrudRepository;

public interface MessageMenuRepository extends CrudRepository<MessageMenu, String> {
}
