package com.example.smartpdv.infra;

import com.example.smartpdv.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long> {


}
