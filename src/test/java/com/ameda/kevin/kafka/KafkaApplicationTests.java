package com.ameda.kevin.kafka;


import com.ameda.kevin.kafka.producer.dto.Worker;
import com.ameda.kevin.kafka.producer.service.MessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
class KafkaApplicationTests {

	@Autowired
	private MessagePublisher messagePublisher;

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	@Container
	static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest")); // kafka container

	@DynamicPropertySource
	public static void initKafkaProps(DynamicPropertyRegistry propRegistry){
		propRegistry.add("spring.kafka.boostrap-servers",kafkaContainer::getBootstrapServers); // get this property from kafkaCobtainer above
	}

	@Test
	public void testSendObjectToTopic(){
		messagePublisher.sendObjectToTopic(
				new Worker(100,"kevin","amedakevin@gmail.com","0797761742"));
		await().pollInterval(Duration.ofSeconds(10)).atMost(10,SECONDS).untilAsserted(()->{

		});
	}

	@Test
	public void testConsumeMessage(){
		log.info("consumption started");
		Worker worker = new Worker(100,"kevin","amedakevin@gmail.com","0797761742");
		kafkaTemplate.send("kevin",worker);
		log.info("consumption ended");
	}
}
