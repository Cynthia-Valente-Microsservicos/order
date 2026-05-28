package store.order;

import lombok.Builder;

@Builder
public record OrderItemOut(
    String id,
    OrderProductOut product,
    Integer quantity,
    Double total
) {
    
}
