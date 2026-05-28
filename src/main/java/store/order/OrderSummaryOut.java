package store.order;

import java.time.LocalDateTime;

public record OrderSummaryOut(
    String id,
    LocalDateTime date,
    Double total
) {
    
}
