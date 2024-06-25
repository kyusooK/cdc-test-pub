package edittemplate.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Value("${api.url.inventory}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/validateInventory/{id}")
    public ResponseEntity<String> inventoryStockCheck(
        @PathVariable(value = "id") Long id
    ) {
        String inventoryUrl = apiUrl + "/inventories/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> inventoryEntity = restTemplate.exchange(
            inventoryUrl,
            HttpMethod.GET,
            entity,
            String.class
        );

        return inventoryEntity;
    }
}
