package tacos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.Domain.TacoOrder;
import tacos.Domain.User;

import java.util.Date;
import java.util.List;

public interface TacoOrderRepo extends JpaRepository<TacoOrder, Integer> {

    List<TacoOrder> findByDeliveryZip(String DeliveryZip);
//    List<TacoOrder> findByDeliveryZipAndPlacedAtBetween(String DeliveryZip, Date start, Date end); // use this after you add the placedat field in the entity.
    List<TacoOrder> findByDeliveryZipAndDeliveryStateOrderByDeliveryCityAllIgnoreCase(String DeliveryTo, String DeliveryState);

    List<TacoOrder> findByUser (User user);
}
