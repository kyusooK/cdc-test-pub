package contracts.messaging
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    // The Identifier which can be used to identify it later.
    label 'StockDecreased'
    input {
        // Contract will be triggered by the following method.
        triggeredBy('stockDecreased()')
    }
    outputMessage {
        sentTo 'eventTopic'
        // Consumer Expected Payload spec. that a JSON message must have, 
        // If the Producer-side test is OK, then send the following msg to event-out channel.
        body(
            eventType: "StockDecreased",
                id: 1,
                stock: 5,
        )
        bodyMatchers {
        }
        headers {
            messagingContentType(applicationJson())
        }
    }
}