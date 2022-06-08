package com.Maker.dao;

        import com.Maker.model.Clinic;
        import com.Maker.model.ClinicPlan;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;


public interface ClinicPlanRepository extends JpaRepository<ClinicPlan, Integer> {

        List<ClinicPlan> findAllByClinic(Clinic clinic);
}
