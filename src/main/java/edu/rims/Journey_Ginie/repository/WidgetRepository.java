package edu.rims.Journey_Ginie.repository;

// import java.util.List;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

// import edu.rims.Journey_Ginie.constant.WidgetStatus;
import edu.rims.Journey_Ginie.entity.Widget;

public interface WidgetRepository extends JpaRepository<Widget, String>{
    // List<Widget> findByWidgetStatus(WidgetStatus widgetStatus, Sort sort);
    
}
    

