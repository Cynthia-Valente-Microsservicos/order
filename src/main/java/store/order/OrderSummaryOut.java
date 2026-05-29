package store.order;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record OrderSummaryOut(
    String id,
    LocalDateTime date,
    Double total
) {
    
}
