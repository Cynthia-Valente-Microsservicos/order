package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/orders")
    public ResponseEntity<Void> create(
        @RequestBody OrderIn in,
        @RequestHeader("idAccount") String idAccount
    );

    @GetMapping("/orders")
    public ResponseEntity<List<OrderSummaryOut>> findAllByAccount(
        @RequestHeader("idAccount") String idAccount
    );

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderOut> findByOrderId(
        @PathVariable String id
    );

    @GetMapping("/orders/health-check")
    public ResponseEntity<Void> healthCheck();
}