package edu.icet.repository.custom;

import edu.icet.entity.Customerentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customerentity,Integer> {
    List<Customerentity> findByName(String name);
    List<Customerentity> findByAddress(String adress);
    List<Customerentity> findBySalary(Double salary);


}
