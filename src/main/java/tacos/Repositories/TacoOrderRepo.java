package tacos.Repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.Domain.TacoOrder;

import java.util.Date;
import java.util.List;

public interface TacoOrderRepo extends CrudRepository<TacoOrder, Integer> {

    List<TacoOrder> findByDeliveryZip(String DeliveryZip);
    List<TacoOrder> findByDeliveryZipAndPlacedAtBetween(String DeliveryZip, Date start, Date end);
    List<TacoOrder> findByDeliveryZipAndDeliveryStateOrderByDeliveryCityAllIgnoreCase(String DeliveryTo, String DeliveryState);
}
