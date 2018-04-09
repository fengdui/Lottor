package com.blueskykong.sc.consumer.listener;

import com.blueskykong.sc.consumer.stream.MsgSink;
import com.blueskykong.tm.common.entity.TransactionMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author keets
 */
@Component
@EnableBinding({MsgSink.class})
public class StreamListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamListener.class);

//    @Autowired
//    private NotificationService notificationService;


    @org.springframework.cloud.stream.annotation.StreamListener(MsgSink.INPUT)
    public void processSMS(Message<TransactionMsg> message) {
        process(message.getPayload());
    }

    private void process(TransactionMsg message) {
        message.getSubTaskId();
//        message.get
        LOGGER.info("===============consume notification message: =======================" + message.toString());
//        throw new RuntimeException();
//        return;
    }
}