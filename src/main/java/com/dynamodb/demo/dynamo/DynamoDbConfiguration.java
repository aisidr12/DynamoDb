package com.dynamodb.demo.dynamo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(buildAmazonDynamoDb());

    }

    private AmazonDynamoDB buildAmazonDynamoDb() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.eu-west-1.amazonaws.com","eu-west-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIATDYWZMFS7FGPR6EH","Ee0tpWODXDnfvPEOL/EC6zyEBXFzwskRc0j8IENv")))
                .build();
    }
}
