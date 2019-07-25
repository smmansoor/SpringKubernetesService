package com.cwm.springKubernetesService;

import io.ap4k.kubernetes.annotation.KubernetesApplication;
import io.ap4k.kubernetes.annotation.Port;
import io.ap4k.kubernetes.annotation.Probe;
import io.ap4k.kubernetes.annotation.ServiceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@KubernetesApplication(ports = @Port(name = "http", containerPort = 8082),
    livenessProbe = @Probe(httpActionPath = "actuator/health"),
    readinessProbe = @Probe(httpActionPath = "actuator/health"),
    serviceType = ServiceType.NodePort)
public class SpringKubernetesServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringKubernetesServiceApplication.class, args);
  }

}
