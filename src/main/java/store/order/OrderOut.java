package store.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record OrderOut(
    String id,
    LocalDateTime date,
    List<OrderItemOut> items,
    Double total
) {
}