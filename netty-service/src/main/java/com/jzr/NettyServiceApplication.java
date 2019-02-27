package com.jzr;



import com.jzr.netty.service.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.jzr.mybatis.mapper")
public class NettyServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NettyServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NettyServer nettyServer = new NettyServer(8888);
		nettyServer.start();
	}

}
