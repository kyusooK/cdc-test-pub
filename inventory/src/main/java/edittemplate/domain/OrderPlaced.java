package edittemplate.domain;

import edittemplate.domain.*;
import edittemplate.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productId;
    private String userId;
    private Integer qty;
    private String productName;
}
