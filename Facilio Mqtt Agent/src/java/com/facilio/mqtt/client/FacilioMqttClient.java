package com.facilio.mqtt.client;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.facilio.mqtt.util.FacilioUtil;

public class FacilioMqttClient 
{
	private AWSIotMqttClient awsIotClient;
	
	public FacilioMqttClient() throws AWSIotException
	{
		connect();
	}
	
	public void connect() throws AWSIotException
	{
		try 
		{
			this.awsIotClient = FacilioUtil.getAwsIotMqttClient();
		}
		catch (AWSIotException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public void publish(String payload) throws AWSIotException
	{
		try 
		{
			awsIotClient.publish(FacilioUtil.FACILIO_IOT_TOPIC, payload);
		} 
		catch (AWSIotException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String arg[])
	{
		try 
		{
			FacilioMqttClient client = new FacilioMqttClient();
			client.publish("Test Shiva");
		} 
		catch (AWSIotException e) 
		{
			e.printStackTrace();
		}
		
	}
}