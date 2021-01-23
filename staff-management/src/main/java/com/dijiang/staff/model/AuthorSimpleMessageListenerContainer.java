package com.dijiang.staff.model;

import lombok.*;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import java.io.Serializable;

@Data
@Builder
@ToString
@Getter
public class AuthorSimpleMessageListenerContainer extends SimpleMessageListenerContainer{

}
